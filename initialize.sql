use jianmu;

DROP TRIGGER IF EXISTS insert_user ;
DROP TRIGGER IF EXISTS delete_teacher;
DROP TRIGGER IF EXISTS delete_student;

DROP TABLE IF EXISTS user_associate_organization;
DROP TABLE IF EXISTS teacher_teach_course;
DROP TABLE IF EXISTS std_study_course;
DROP TABLE IF EXISTS user_compose_group;
DROP TABLE IF EXISTS user_apply_job;
DROP TABLE IF EXISTS organization_post_job;
DROP TABLE IF EXISTS user_post_job;

DROP TABLE IF EXISTS organization;
DROP TABLE IF EXISTS `group`;
DROP TABLE IF EXISTS job;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS teacher;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS user_tag;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS college;

CREATE TABLE college(
    id              TINYINT PRIMARY KEY COMMENT '系号',
    title           NVARCHAR(20) NOT NULL COMMENT '学院名称',
    logo_url        VARCHAR(50) COMMENT '头像url'
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user`(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    email           VARCHAR(320) NOT NULL COMMENT '登录邮箱',
    name            NVARCHAR(20) NOT NULL DEFAULT '' COMMENT '姓名',
    password        VARCHAR(20) NOT NULL DEFAULT '' COMMENT '密码',
#     school_id       VARCHAR(16) NOT NULL DEFAULT '' COMMENT '学工号',
#     major           TINYINT COMMENT '系号',
    campus          TINYINT COMMENT '校区 1:南校区 2:北校区',
    college_id      TINYINT COMMENT '系号',
    create_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    last_login_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '上次登录时间',
    profile         NVARCHAR(255) COMMENT '个人简介 不超过255字',
    avatar_url      VARCHAR(50) COMMENT '头像url',
    FOREIGN KEY (college_id) REFERENCES college(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE user_tag(
    user_id         INT PRIMARY KEY,
    tag             NVARCHAR(20) NOT NULL DEFAULT '' COMMENT '标签',
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE student(
    user_id         INT PRIMARY KEY ,
    student_id      VARCHAR(16) NOT NULL DEFAULT '' COMMENT '学号',
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE teacher(
    user_id         INT PRIMARY KEY ,
    teacher_id      VARCHAR(16) NOT NULL DEFAULT '' COMMENT '工号',
    title           NVARCHAR(5) COMMENT '职称',
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE course(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    title           NVARCHAR(20) NOT NULL COMMENT '课程名 不超过20字',
    capacity        INT NOT NULL COMMENT '课程容量',
    profile         NVARCHAR(511) COMMENT '课程简介 不超过511字',
    college_id      TINYINT COMMENT '学院(系号)',
    create_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (college_id) REFERENCES college(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE job(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    title           NVARCHAR(20) NOT NULL COMMENT '项目名 不超过20字',
    college_id      TINYINT COMMENT '学院(系号)',
    campus          TINYINT COMMENT '校区 1:南校区 2:北校区',
    expected_num_of_member   SMALLINT COMMENT '预计需求人数',
    state           TINYINT DEFAULT 1 COMMENT '任务状态 1:招募中 2:招募结束',
    profile         NVARCHAR(511) COMMENT '任务简介 不超过511字',
    email           VARCHAR(320) COMMENT '项目邮箱',
    telephone       VARCHAR(15) COMMENT '电话',
    course_id       INT COMMENT '隶属课程',
    organization    INT COMMENT '隶属组织',
    create_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (course_id) REFERENCES course(id),
    FOREIGN KEY (college_id) REFERENCES college(id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `group`(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    title           NVARCHAR(20) NOT NULL DEFAULT '' COMMENT '名称',
    leader_id       INT COMMENT '组长id',
    state           TINYINT NOT NULL DEFAULT 1 COMMENT '小组状态 1:运行中 2:已解散',
    job_id          INT COMMENT '负责项目id',
    create_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (leader_id) REFERENCES user(id),
    FOREIGN KEY (job_id) REFERENCES job(id) ON DELETE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE organization(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    title           NVARCHAR(20) NOT NULL COMMENT '组织名 不超过20字',
    profile         NVARCHAR(511) COMMENT '组织简介 不超过511字',
    create_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    update_at       TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE user_post_job(
    job_id          INT PRIMARY KEY DEFAULT 1 COMMENT '发布项目',
    user_id         INT NOT NULL DEFAULT 1 COMMENT '发布人',
    start_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
    expected_end_time   DATETIME COMMENT '预计结束时间',
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES job(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE organization_post_job(
    job_id          INT PRIMARY KEY DEFAULT 1 COMMENT '发布项目',
    organization_id  INT NOT NULL DEFAULT 1 COMMENT '发布人',
    start_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
    expected_end_time   DATETIME COMMENT '预计结束时间',
    FOREIGN KEY (organization_id) REFERENCES organization(id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES job(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_apply_job(
    user_id         INT NOT NULL DEFAULT 1 COMMENT '申请人',
    job_id          INT NOT NULL DEFAULT 1 COMMENT '申请项目',
    content         NVARCHAR(255) COMMENT '申请理由',
    status          TINYINT NOT NULL DEFAULT 1 COMMENT '申请状态 1:待审核 2:已通过 3:被拒绝',
    apply_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
    reply_at        TIMESTAMP COMMENT '审核时间',
    PRIMARY KEY (user_id, job_id),
    FOREIGN KEY (user_id) REFERENCES student(user_id) ON DELETE CASCADE ,
    FOREIGN KEY (job_id) REFERENCES job(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_compose_group(
    user_id         INT COMMENT '成员',
    group_id        INT COMMENT '小组',
    PRIMARY KEY (user_id, group_id),
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ,
    FOREIGN KEY (group_id) REFERENCES `group`(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE teacher_teach_course(
    teacher_id      INT COMMENT '教师',
    course_id       INT COMMENT '课程',
    PRIMARY KEY (teacher_id, course_id),
    FOREIGN KEY (teacher_id) REFERENCES teacher(user_id) ON DELETE CASCADE ,
    FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE std_study_course(
    student_id      INT NOT NULL DEFAULT 1 COMMENT '申请学生',
    course_id       INT NOT NULL DEFAULT 1 COMMENT '申请课程',
    content         NVARCHAR(255) COMMENT '申请理由',
    status          TINYINT NOT NULL DEFAULT 1 COMMENT '申请状态 1:待审核 2:已通过 3:被拒绝 4:撤回/退出',
    apply_at        TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
    reply_at        DATETIME COMMENT '审核时间',
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES student(user_id) ON DELETE CASCADE ,
    FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_associate_organization(
    user_id         INT COMMENT '用户',
    organization_id INT COMMENT '组织',
    status          TINYINT NOT NULL DEFAULT 1 COMMENT '申请状态 1:待审核 2:普通成员 3:管理员 4:被拒绝 5:撤回/退出',
    PRIMARY KEY (user_id, organization_id),
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ,
    FOREIGN KEY (organization_id) REFERENCES organization(id) ON DELETE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO college VALUES (1, '材料科学与工程学院', '');
INSERT INTO college VALUES (2, '电子信息工程学院', '');
INSERT INTO college VALUES (3, '自动化科学与电气工程学院', '');
INSERT INTO college VALUES (4, '能源与动力工程学院', '');
INSERT INTO college VALUES (5, '航空科学与工程学院', '');
INSERT INTO college VALUES (6, '计算机学院', '');
INSERT INTO college VALUES (7, '机械工程及自动化学院', '');
INSERT INTO college VALUES (8, '经济管理学院', '');
INSERT INTO college VALUES (9, '数学科学学院', '');
INSERT INTO college VALUES (10, '生物与医学工程学院', '');
INSERT INTO college VALUES (11, '人文社会科学学院', '');
INSERT INTO college VALUES (12, '外国语学院', '');
INSERT INTO college VALUES (13, '交通科学与工程学院', '');
INSERT INTO college VALUES (14, '可靠性与系统工程学院', '');
INSERT INTO college VALUES (15, '宇航学院', '');
INSERT INTO college VALUES (16, '飞行学院', '');
INSERT INTO college VALUES (17, '仪器科学与光电工程学院', '');
INSERT INTO college VALUES (18, '北京学院', '');
INSERT INTO college VALUES (19, '物理学院', '');
INSERT INTO college VALUES (20, '法学院', '');
INSERT INTO college VALUES (21, '软件学院', '');
INSERT INTO college VALUES (22, '现代远程教育学院', '');
INSERT INTO college VALUES (23, '高等理工学院', '');
INSERT INTO college VALUES (24, '中法工程师学院', '');
INSERT INTO college VALUES (25, '国际学院', '');
INSERT INTO college VALUES (26, '新媒体艺术与设计学院', '');
INSERT INTO college VALUES (27, '化学学院', '');
INSERT INTO college VALUES (28, '马克思主义学院', '');
INSERT INTO college VALUES (29, '人文与社会科学高等研究院', '');
INSERT INTO college VALUES (30, '空间与环境学院', '');
INSERT INTO college VALUES (31, '武装部', '');
INSERT INTO college VALUES (32, '工程训练中心', '');
INSERT INTO college VALUES (33, '体育部', '');
INSERT INTO college VALUES (34, '图书馆', '');
INSERT INTO college VALUES (35, '国际通用工程学院', '');
INSERT INTO college VALUES (36, '校医院', '');
INSERT INTO college VALUES (37, '招生就业处', '');
INSERT INTO college VALUES (38, '无人机所', '');
INSERT INTO college VALUES (39, '网络空间安全学院', '');
INSERT INTO college VALUES (40, '校机关', '');
INSERT INTO college VALUES (41, '继续教育学院', '');
INSERT INTO college VALUES (42, '人工智能研究院', '');
INSERT INTO college VALUES (43, '电子信息工程学院', '');
INSERT INTO college VALUES (44, '研究生院', '');
INSERT INTO college VALUES (45, '北航暑期学校', '');
INSERT INTO college VALUES (49, '微电子学院', '');
INSERT INTO college VALUES (50, '校际', '');
INSERT INTO college VALUES (51, '学生处武装部', '');
INSERT INTO college VALUES (53, '团委', '');
INSERT INTO college VALUES (56, '校内其它单位', '');
INSERT INTO college VALUES (60, '校外单位', '');
INSERT INTO college VALUES (61, '学生发展服务中心', '');
INSERT INTO college VALUES (70, '北航学院', '');

CREATE TRIGGER insert_user
    AFTER INSERT ON `user`
    FOR EACH ROW
BEGIN
    IF NEW.email NOT REGEXP '^([\-A-Za-z0-9_\.])+\@([\-A-Za-z0-9_\.])+\.([A-Za-z]{2,4})$' THEN
        DELETE FROM `user` WHERE email=NEW.email;
    END IF;
END;

CREATE TRIGGER delete_teacher
    AFTER DELETE ON `teacher`
    FOR EACH ROW
        DELETE FROM `user` WHERE OLD.user_id=`user`.id;

CREATE TRIGGER delete_student
    AFTER DELETE ON `student`
    FOR EACH ROW
        DELETE FROM `user` WHERE OLD.user_id=`user`.id;