<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="zh">
    <%--trimDirectiveWhitespaces="true" --%>

        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <title>简募</title>
            <link rel="icon" href="assets/img/logo-mini.png" sizes="32x32">
            <!-- All Plugins Css -->
            <link href="assets/css/plugins.css" rel="stylesheet">


            <!-- Custom CSS -->
            <link href="assets/css/styles.css" rel="stylesheet">

            <!-- Custom Color -->
            <script src="assets/js/jquery-1.12.4.min.js"></script>
            <link href="assets/css/skin/default.css" rel="stylesheet">
            <link href="assets/css/sweetalert.css" rel="stylesheet">
            <script src="assets/js/sweetalert-dev.js"></script>
            <script src="assets/js/ajax/signin.js"></script>
            <script src="assets/js/ajax/signup.js"></script>
            <script src="assets/js/ajax/init.js"></script>
        </head>

        <body class="blue-skin">
            <!-- ============================================================== -->
            <!-- Preloader - style you can find in spinners.css -->
            <!-- ============================================================== -->
            <div class="Loader"></div>

            <!-- ============================================================== -->
            <!-- Main wrapper - style you can find in pages.scss -->
            <!-- ============================================================== -->
            <div id="main-wrapper">

                <!-- ============================================================== -->
                <!-- Top header  -->
                <!-- ============================================================== -->
                <!-- Start Navigation -->
                <div class="header header-light">
                    <div class="container-fluid">
                        <nav id="navigation" class="navigation navigation-landscape">
                            <div class="nav-header">
                                <a class="nav-brand" href="#">
                                    <img src="assets/img/logo.png" class="logo" alt="" />
                                </a>
                                <div class="nav-toggle"></div>
                            </div>
                            <div class="nav-menus-wrapper" style="transition-property: none;">
                                <ul class="nav-menu">
                                    <li><a href="#">我要找事做<span class="submenu-indicator"></span></a>
                                        <ul class="nav-dropdown nav-submenu" style="right: auto; display: none;">
                                            <li><a href="all-courses.html">全部课程</a></li>
                                            <li><a href="search-full-width.html">搜索任务</a></li>
                                            <li><a href="employers-list.html">搜索招募人</a></li>
                                            <li><a id="personal-info" href="candidate-dashboard.html#profile">个人资料</a></li>
                                        </ul>
                                    </li>

                                    <li><a href="#">我要找队友<span class="submenu-indicator"></span></a>
                                        <ul class="nav-dropdown nav-submenu" style="right: auto; display: none;">
                                            <li><a href="candidate-grid.html">搜索候选人</a></li>
                                            <li><a id="recruit-manage" href="candidate-dashboard.html#manage-jobs">招募管理</a></li>
                                        </ul>
                                    </li>

                                    <li><a href="blog.html">博客</a></li>

                                    <li><a href="contact.html">联系我们</a></li>

                                </ul>

                                <ul class="nav-menu nav-menu-social align-to-right">

                                    <li id="user-name-space" style="display: none">
                                        <a href="candidate-dashboard.html">
                                            <i class="ti-user mr-1"></i><span id="user-name-label" class="dn-lg">username</span>
                                        </a>
                                    </li>
                                    <li id="sign-up&sign-in">
                                        <a href="#" data-toggle="modal" data-target="#login">
                                            <i class="ti-user mr-1"></i><span class="dn-lg">登录/注册</span>
                                        </a>
                                    </li>
                                    <li id="post-job-after-login" class="add-listing theme-bg">
                                        <a href="candidate-dashboard.html#post-new-job">
                                            <i class="ti-plus"></i> 发布任务
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </nav>
                    </div>
                </div>
                <!-- End Navigation -->
                <div class="clearfix"></div>
                <!-- ============================================================== -->
                <!-- Top header  -->
                <!-- ============================================================== -->


                <!-- ============================ Hero Banner  Start================================== -->
                <div class="hero-header jumbo-banner text-center" style="background: url(assets/img/校园3.jpg);" data-overlay="6">
                    <div class="container">
                        <h1>在这里寻找你心仪的队友！</h1>
                        <p class="lead">您可以在此发布一则招募或领取一份任务</p>
                        <form class="search-big-form no-border search-shadow">
                            <div class="row m-0">
                                <div class="col-lg-4 col-md-4 col-sm-12 p-0">
                                    <div class="form-group">
                                        <i class="ti-search"></i>
                                        <input id="key-words" type="text" class="form-control b-r" placeholder="任务关键字">
                                    </div>
                                </div>

                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                    <div class="form-group">
                                        <select id="category-2" class="js-states form-control">
                                <option value="0">不指定校区</option>
                                <option value="1">南校区（学院路）</option>
                                <option value="2">北校区（沙河）</option>
                            </select>
                                        <i class="ti-location-pin"></i>
                                    </div>
                                </div>

                                <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                    <div class="form-group">
                                        <select id="category" class="js-states form-control">
                                <option value="0">不指定学院</option>
                                <option value="1">[01]材料科学与工程学院</option>
                                <option value="2">[02]电子信息工程学院</option>
                                <option value="3">[03]自动化科学与电气工程学院</option>
                                <option value="4">[04]能源与动力工程学院</option>
                                <option value="5">[05]航空科学与工程学院</option>
                                <option value="6">[06]计算机学院</option>
                                <option value="7">[07]机械工程及自动化学院</option>
                                <option value="8">[08]经济管理学院</option>
                                <option value="9">[09]数学科学学院</option>
                                <option value="10">[10]生物与医学工程学院</option>
                                <option value="11">[11]人文社会科学学院</option>
                                <option value="12">[12]外国语学院</option>
                                <option value="13">[13]交通科学与工程学院</option>
                                <option value="14">[14]可靠性与系统工程学院</option>
                                <option value="15">[15]宇航学院</option>
                                <option value="16">[16]飞行学院</option>
                                <option value="17">[17]仪器科学与光电工程学院</option>
                                <option value="18">[18]北京学院</option>
                                <option value="19">[19]物理学院</option>
                                <option value="20">[20]法学院</option>
                                <option value="21">[21]软件学院</option>
                                <option value="22">[22]现代远程教育学院</option>
                                <option value="23">[23]高等理工学院</option>
                                <option value="24">[24]中法工程师学院</option>
                                <option value="25">[25]国际学院</option>
                                <option value="26">[26]新媒体艺术与设计学院</option>
                                <option value="27">[27]化学学院</option>
                                <option value="28">[28]马克思主义学院</option>
                                <option value="29">[29]人文与社会科学高等研究院</option>
                                <option value="30">[30]空间与环境学院</option>
                                <option value="31">[31]武装部</option>
                                <option value="32">[32]工程训练中心</option>
                                <option value="33">[33]体育部</option>
                                <option value="34">[34]图书馆</option>
                                <option value="35">[35]国际通用工程学院</option>
                                <option value="36">[36]校医院</option>
                                <option value="37">[37]招生就业处</option>
                                <option value="38">[38]无人机所</option>
                                <option value="39">[39]网络空间安全学院</option>
                                <option value="40">[40]校机关</option>
                                <option value="41">[41]继续教育学院</option>
                                <option value="42">[42]人工智能研究院</option>
                                <option value="44">[44]研究生院</option>
                                <option value="45">[45]北航暑期学校</option>
                                <option value="49">[49]微电子学院</option>
                                <option value="50">[50]校际</option>
                                <option value="51">[51]学生处武装部</option>
                                <option value="53">[53]团委</option>
                                <option value="56">[56]校内其它单位</option>
                                <option value="60">[60]校外单位</option>
                                <option value="61">[61]学生发展服务中心</option>
                                <option value="70">[70]北航学院</option>
                                <option value="231">[231]高等理工学院（华罗庚班）</option>
                            </select>
                                        <i class="ti-layers"></i>
                                    </div>
                                </div>

                                <div class="col-lg-2 col-md-2 col-sm-12 p-0">
                                    <button onclick="javascript:window.location.href='search-full-width.html'
                        +'#'+$('#key-words').val()+'#'
                        + $('#category').val()+'#'+$('#category-2').val()" type="button" class="btn btn-primary full-width">出发！
                        </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- ============================ Hero Banner End ================================== -->

                <!-- ============================ Latest job ================================== -->
                <section>
                    <div class="container">

                        <div class="row">
                            <div class="col text-center">
                                <div class="sec-heading mx-auto">
                                    <h2>七大姑八大姨都推荐的任务</h2>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="owl-carousel" id="job-slide">

                                <!-- Single Job -->
                                <div class="item">
                                    <div class="job-grid style-1">
                                        <div class="job-grid-wrap">
                                            <span class="job-type j-part-time">Part Time</span>
                                            <div class="job-grid-thumb">
                                                <a href="job-detail.html"><img src="assets/img/微电子.png" class="img-fluid mx-auto" alt="" /></a>
                                            </div>
                                            <h4 class="job-title"><a href="job-detail.html">Product Manager</a></h4>
                                            <hr>
                                            <div class="job-grid-detail">
                                                <h4 class="jbc-name"><a href="employer-detail.html">Alliziance Tech</a></h4>
                                                <p><i class="ti-location-pin"></i>325, New Market, New York </p>
                                            </div>
                                            <div class="job-grid-footer">
                                                <h4 class="job-price">$7,247</h4>
                                                <a href="job-detail.html" class="btn btn-outline-info btn-rounded">Apply</a>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <!-- Single Job -->
                                <div class="item">
                                    <div class="job-grid style-1">
                                        <div class="job-grid-wrap">
                                            <div class="featured-job"><i class="ti-star filled"></i></div>
                                            <span class="job-type j-full-time">Full Time</span>
                                            <div class="job-grid-thumb">
                                                <a href="job-detail.html"><img src="assets/img/材料科学与工程.png" class="img-fluid mx-auto" alt="" /></a>
                                            </div>
                                            <h4 class="job-title"><a href="job-detail.html">Project & Team Head</a></h4>
                                            <hr>
                                            <div class="job-grid-detail">
                                                <h4 class="jbc-name"><a href="employer-detail.html">Asana Inc.</a></h4>
                                                <p><i class="ti-location-pin"></i>356, Blick Shop, London </p>
                                            </div>
                                            <div class="job-grid-footer">
                                                <h4 class="job-price">$3,254</h4>
                                                <a href="job-detail.html" class="btn btn-outline-info btn-rounded">Apply</a>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <!-- Single Job -->
                                <div class="item">
                                    <div class="job-grid style-1">
                                        <div class="job-grid-wrap">
                                            <span class="job-type j-full-time">Full Time</span>
                                            <div class="job-grid-thumb">
                                                <a href="job-detail.html"><img src="assets/img/经管.png" class="img-fluid mx-auto" alt="" /></a>
                                            </div>
                                            <h4 class="job-title"><a href="job-detail.html">Web Designer</a></h4>
                                            <hr>
                                            <div class="job-grid-detail">
                                                <h4 class="jbc-name"><a href="employer-detail.html">Drive Tech</a></h4>
                                                <p><i class="ti-location-pin"></i>New Market, United State </p>
                                            </div>
                                            <div class="job-grid-footer">
                                                <h4 class="job-price">$5,747</h4>
                                                <a href="job-detail.html" class="btn btn-outline-info btn-rounded">Apply</a>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <!-- Single Job -->
                                <div class="item">
                                    <div class="job-grid style-1">
                                        <div class="job-grid-wrap">
                                            <div class="featured-job"><i class="ti-star filled"></i></div>
                                            <span class="job-type j-freelance-time">Freelance</span>
                                            <div class="job-grid-thumb">
                                                <a href="job-detail.html"><img src="assets/img/航空科学与工程学院.png" class="img-fluid mx-auto" alt="" /></a>
                                            </div>
                                            <h4 class="job-title"><a href="job-detail.html">Sales Analytics</a></h4>
                                            <hr>
                                            <div class="job-grid-detail">
                                                <h4 class="jbc-name"><a href="employer-detail.html">Photos Info.</a></h4>
                                                <p><i class="ti-location-pin"></i>325, New Market, New York </p>
                                            </div>
                                            <div class="job-grid-footer">
                                                <h4 class="job-price">$6,357</h4>
                                                <a href="job-detail.html" class="btn btn-outline-info btn-rounded">Apply</a>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <!-- Single Job -->
                                <div class="item">
                                    <div class="job-grid style-1">
                                        <div class="job-grid-wrap">
                                            <span class="job-type j-part-time">Part Time</span>
                                            <div class="job-grid-thumb">
                                                <a href="job-detail.html"><img src="assets/img/计算机学院.png" class="img-fluid mx-auto" alt="" /></a>
                                            </div>
                                            <h4 class="job-title"><a href="job-detail.html">Product Manager</a></h4>
                                            <hr>
                                            <div class="job-grid-detail">
                                                <h4 class="jbc-name"><a href="employer-detail.html">Google Info.</a></h4>
                                                <p><i class="ti-location-pin"></i>325, Rack Newer, England </p>
                                            </div>
                                            <div class="job-grid-footer">
                                                <h4 class="job-price">$10,047</h4>
                                                <a href="job-detail.html" class="btn btn-outline-info btn-rounded">Apply</a>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                                <!-- Single Job -->
                                <div class="item">
                                    <div class="job-grid style-1">
                                        <div class="job-grid-wrap">
                                            <div class="featured-job"><i class="ti-star filled"></i></div>
                                            <span class="job-type j-temporary-time">Temporary</span>
                                            <div class="job-grid-thumb">
                                                <a href="job-detail.html"><img src="assets/img/网安.png" class="img-fluid mx-auto" alt="" /></a>
                                            </div>
                                            <h4 class="job-title"><a href="job-detail.html">Team Director</a></h4>
                                            <hr>
                                            <div class="job-grid-detail">
                                                <h4 class="jbc-name"><a href="employer-detail.html">PayPal Info.</a></h4>
                                                <p><i class="ti-location-pin"></i>254, New Buklack, London </p>
                                            </div>
                                            <div class="job-grid-footer">
                                                <h4 class="job-price">$8,247</h4>
                                                <a href="job-detail.html" class="btn btn-outline-info btn-rounded">Apply</a>
                                            </div>

                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>

                    </div>
                </section>
                <!-- ============================ Latest Job End ================================== -->

                <!-- ============================ Category Start ================================== -->
                <section class="gray">
                    <div class="container">

                        <div class="row">
                            <div class="col text-center">
                                <div class="sec-heading mx-auto">
                                    <h2>热门任务类型</h2>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <ul class="category-wrap">

                                <li>
                                    <a href="search.html" class="standard-category-box">
                                        <i class="ti-money"></i>
                                        <h4>Account / Finance</h4>
                                        <span>10 new job posted</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="search.html" class="standard-category-box">
                                        <i class="ti-headphone-alt"></i>
                                        <h4>Telecommunications</h4>
                                        <span>12 new job posted</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="search.html" class="standard-category-box">
                                        <i class="ti-book"></i>
                                        <h4>Education Training</h4>
                                        <span>8 new job posted</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="search.html" class="standard-category-box">
                                        <i class="ti-car"></i>
                                        <h4>Automotive Jobs</h4>
                                        <span>16 new job posted</span>
                                    </a>
                                </li>


                            </ul>

                        </div>

                    </div>
                </section>
                <div class="clearfix"></div>
                <!-- ============================ Category End ================================== -->

                <!-- ============================ Counter Facts  Start================================== -->
                <section class="image-bg text-center" style="background:#3a72bc url(assets/img/bg2.png);" data-overlay="0">
                    <div class="container">
                        <div class="row">

                            <div class="col-lg-4 col-md-3 col-sm-6 b-r">
                                <div class="count-facts">
                                    <h4>0</h4>
                                    <!--此处应该为一个变量-->
                                    <span>网站任务数量</span>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-3 col-sm-6 b-r">
                                <div class="count-facts">
                                    <h4>0</h4>
                                    <!--此处应该为一个变量-->
                                    <span>已完结的任务量</span>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-3 col-sm-6">
                                <div class="count-facts">
                                    <h4>0</h4>
                                    <!--此处应该为一个变量-->
                                    <span>注册用户</span>
                                </div>
                            </div>

                        </div>
                    </div>
                </section>
                <!-- ============================ Counter Facts End ================================== -->

                <!-- ============================ Testimonial  Start================================== -->
                <section class="image-bg text-center" style="background: url(assets/img/校园7.jpg);" data-overlay="8">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-10 col-md-10">
                                <div class="owl-carousel testimonial-3" id="testimonial-3-slide">

                                    <!-- Single Testimonial -->
                                    <div class="item">
                                        <div class="tauth-thumb">
                                            <img src="assets/img/伏拉夫.jpg" class="mx-auto img-circle" alt="" />
                                        </div>
                                        <div class="tauth-detail">
                                            <h4 class="tauth-title">伏拉夫</h4>
                                            <span class="tauth-subtitle">一个爱中国的歪果仁</span>
                                            <p>我们北航真是太棒了！<br> 俄罗斯的数据库课，不行！
                                                <br> 中国的数据库课，行！
                                            </p>
                                        </div>
                                    </div>

                                    <!-- Single Testimonial -->
                                    <div class="item">
                                        <div class="tauth-thumb">
                                            <img src="assets/img/user-2.jpg" class="mx-auto img-circle" alt="" />
                                        </div>
                                        <div class="tauth-detail">
                                            <h4 class="tauth-title">Riya Kilwarnia</h4>
                                            <span class="tauth-subtitle">UI/UX Desihner</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua consectetur adipiscing elit. consectetur adipiscing elit, sed do eiusmod tempor incididunt</p>
                                        </div>
                                    </div>

                                    <!-- Single Testimonial -->
                                    <div class="item">
                                        <div class="tauth-thumb">
                                            <img src="assets/img/user-3.jpg" class="mx-auto img-circle" alt="" />
                                        </div>
                                        <div class="tauth-detail">
                                            <h4 class="tauth-title">Daniel Wartion</h4>
                                            <span class="tauth-subtitle">App Developer</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua consectetur adipiscing elit. consectetur adipiscing elit, sed do eiusmod tempor incididunt</p>
                                        </div>
                                    </div>

                                    <!-- Single Testimonial -->
                                    <div class="item">
                                        <div class="tauth-thumb">
                                            <img src="assets/img/user-4.jpg" class="mx-auto img-circle" alt="" />
                                        </div>
                                        <div class="tauth-detail">
                                            <h4 class="tauth-title">Ritika Uswana</h4>
                                            <span class="tauth-subtitle">Software Developer</span>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua consectetur adipiscing elit. consectetur adipiscing elit, sed do eiusmod tempor incididunt</p>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- ============================ Testimonial End ================================== -->

                <!-- ============================ Blog Start ================================== -->
                <section>
                    <div class="container">

                        <div class="row">
                            <div class="col text-center">
                                <div class="sec-heading mx-auto">
                                    <h2>最新消息</h2>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-4 col-md-4">
                                <div class="blog-grid-wrap mb-4">
                                    <div class="blog-grid-thumb">
                                        <a href="blog-detail.html"><img src="assets/img/module-1.jpg" class="img-responsive" alt=""></a>
                                        <div class="bg-cat-info">
                                            <div class="post-m-info">
                                                <h5 class="pm-date">12</h5>
                                                <h5 class="pm-month">Dec</h5>
                                            </div>
                                        </div>
                                        <h6 class="post-cat">Travel &amp; Tour</h6>
                                    </div>
                                    <div class="blog-grid-content">
                                        <h4 class="cnt-gb-title"><a href="blog-detail.html">Why most People used bootstrap
                                framework?</a></h4>
                                        <p>不会吧，不会吧，不会真的有人以为我们会开通博客功能吧？</p>
                                    </div>
                                    <div class="blog-grid-meta">
                                        <div class="gb-info-author">
                                            <p><strong>By </strong>Mokoghost</p>
                                        </div>
                                        <div class="gb-info-cmt">
                                            <ul>
                                                <li><a href="#">110<i class="fa fa-comment text-info"></i></a></li>
                                                <li><a href="#">50<i class="fa fa-heart text-info"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-4">
                                <div class="blog-grid-wrap mb-4">
                                    <div class="blog-grid-thumb">
                                        <a href="blog-detail.html"><img src="assets/img/module-2.jpg" class="img-responsive" alt=""></a>
                                        <div class="bg-cat-info">
                                            <div class="post-m-info">
                                                <h5 class="pm-date">10</h5>
                                                <h5 class="pm-month">Jan</h5>
                                            </div>
                                        </div>
                                        <h6 class="post-cat">Technology &amp; Fashion</h6>
                                    </div>
                                    <div class="blog-grid-content">
                                        <h4 class="cnt-gb-title"><a href="blog-detail.html">drizvato Launch New &amp; powerful
                                template</a></h4>
                                        <p>不会吧，不会吧，不会真的有人以为我们会开通博客功能吧？</p>
                                    </div>
                                    <div class="blog-grid-meta">
                                        <div class="gb-info-author">
                                            <p><strong>By </strong>Mokoghost</p>
                                        </div>
                                        <div class="gb-info-cmt">
                                            <ul>
                                                <li><a href="#">20<i class="fa fa-comment text-info"></i></a></li>
                                                <li><a href="#">40<i class="fa fa-heart text-info"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-4 col-md-4">
                                <div class="blog-grid-wrap mb-4">
                                    <div class="blog-grid-thumb">
                                        <a href="blog-detail.html"><img src="assets/img/module-3.jpg" class="img-responsive" alt=""></a>
                                        <div class="bg-cat-info">
                                            <div class="post-m-info">
                                                <h5 class="pm-date">10</h5>
                                                <h5 class="pm-month">Feb</h5>
                                            </div>
                                        </div>
                                        <h6 class="post-cat">Business</h6>
                                    </div>
                                    <div class="blog-grid-content">
                                        <h4 class="cnt-gb-title"><a href="blog-detail.html">Which Features is best in drizvato
                                Theme?</a></h4>
                                        <p>不会吧，不会吧，不会真的有人以为我们会开通博客功能吧？</p>
                                    </div>
                                    <div class="blog-grid-meta">
                                        <div class="gb-info-author">
                                            <p><strong>By </strong>Mokoghost</p>
                                        </div>
                                        <div class="gb-info-cmt">
                                            <ul>
                                                <li><a href="#">250<i class="fa fa-comment text-info"></i></a></li>
                                                <li><a href="#">40<i class="fa fa-heart text-info"></i></a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </section>
                <!-- ============================ Blog End ================================== -->

                <!-- ============================ Newsletter Start(此段为向用户邮箱发送工作招募提醒，暂缓) ================================== -->
                <span>
    <!--    <section class="alert-wrap pt-5 pb-5" style="background: #00a94f url(assets/img/bg2.png);">-->
        <!--        <div class="container">-->
        <!--            <div class="row">-->
        <!--                <div class="col-lg-6 col-md-6">-->
        <!--                    <div class="jobalert-sec">-->
        <!--                        <h3 class="mb-1 text-light">Get New Jobs Notification!</h3>-->
        <!--                        <p class="text-light">Subscribe & get all related jobs notification.</p>-->
        <!--                    </div>-->
        <!--                </div>-->

        <!--                <div class="col-lg-6 col-md-6">-->
        <!--                    <div class="input-group">-->
        <!--                        <input type="text" class="form-control" placeholder="Enter Your Email">-->
        <!--                        <div class="input-group-append">-->
        <!--                            <button type="button" class="btn btn-black black">Subscribe</button>-->
        <!--                        </div>-->
        <!--                    </div>-->
        <!--                </div>-->
        <!--            </div>-->
        <!--        </div>-->
        <!--    </section>-->
    </span>
                <!-- ============================ Newsletter Start ================================== -->

                <!-- ============================ Footer Start ================================== -->
                <footer class="dark-footer skin-dark-footer">
                    <div>
                        <div class="container">
                            <div class="row">

                                <div class="col-lg-4 col-md-4">
                                    <div class="footer-widget">
                                        <img src="assets/img/logo-light.png" class="img-footer" alt="" />
                                        <div class="footer-add">
                                            <p>BEIHANG UNIVERSITY XUEYUAN ROAD<br> NO.37,HAIDIAN DISTRICT</br> China</p>
                                            <p><strong>Email:</strong></br><a href="mailto:mokoghost@gmail.com">mokoghost@gmail.com</a></p>
                                            <!--                                <p><strong>Call:</strong></br></p>-->
                                        </div>

                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <div class="footer-widget">
                                        <h4 class="widget-title">导航</h4>
                                        <ul class="footer-menu">
                                            <li><a href="blog.html">全部博客</a></li>
                                            <li><a href="all-courses.html">浏览全部用户</a></li>
                                            <li><a href="all-courses.html">浏览全部招募</a></li>
                                            <li><a href="#">回到顶部</a></li>
                                        </ul>
                                    </div>
                                </div>

                                <div class="col-lg-4 col-md-4">
                                    <div class="footer-widget">
                                        <h4 class="widget-title">我的账号</h4>
                                        <ul class="footer-menu">
                                            <li><a href="candidate-dashboard.html#profile">个人资料</a></li>
                                            <li><a href="https://www.bilibili.com">看会B站</a></li>
                                            <li><a href="javascript:void(0)" data-toggle="modal" data-target="#signup" data-dismiss="modal">注册</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <!--APP下载-->
                                <!--                    <div class="col-lg-3 col-md-3">-->
                                <!--                        <div class="footer-widget">-->
                                <!--                            <h4 class="widget-title">Download Apps</h4>-->
                                <!--                            <a href="#" class="other-store-link">-->
                                <!--                                <div class="other-store-app">-->
                                <!--                                    <div class="os-app-icon">-->
                                <!--                                        <i class="ti-android theme-cl"></i>-->
                                <!--                                    </div>-->
                                <!--                                    <div class="os-app-caps">-->
                                <!--                                        Google Play-->
                                <!--                                        <span>Get It Now</span>-->
                                <!--                                    </div>-->
                                <!--                                </div>-->
                                <!--                            </a>-->
                                <!--                            <a href="#" class="other-store-link">-->
                                <!--                                <div class="other-store-app">-->
                                <!--                                    <div class="os-app-icon">-->
                                <!--                                        <i class="ti-apple theme-cl"></i>-->
                                <!--                                    </div>-->
                                <!--                                    <div class="os-app-caps">-->
                                <!--                                        App Store-->
                                <!--                                        <span>Now it Available</span>-->
                                <!--                                    </div>-->
                                <!--                                </div>-->
                                <!--                            </a>-->
                                <!--                        </div>-->
                                <!--                    </div>-->

                            </div>
                        </div>
                    </div>

                    <div class="footer-bottom">
                        <div class="container">
                            <div class="row align-items-center">

                                <div class="col-lg-6 col-md-6">
                                    <p class="mb-0">Copyright &copy; 2020 www.jianmu.com All rights reserved.</p>
                                </div>

                                <div class="col-lg-6 col-md-6 text-right">
                                    <ul class="footer-bottom-social">
                                        <li><a href="#"><i class="lni-wechat"></i></a></li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                    </div>
                </footer>
                <!-- ============================ Footer End ================================== -->

                <!-- Log In Modal -->
                <div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="registermodal" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered login-pop-form" role="document">
                        <div class="modal-content" id="registermodal">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true"><i class="ti-close"></i></span>
                    </button>
                            </div>
                            <div class="modal-body">
                                <h4 class="modal-header-title">登录</h4>
                                <!--使用其他社交软件登录，暂无-->
                                <!--                    <div class="social-login">-->
                                <!--                        <ul>-->
                                <!--                            <li><a href="#" class="btn connect-fb"><i class="ti-facebook"></i>使用QQ登录</a>-->
                                <!--                            </li>-->
                                <!--                            <li><a href="#" class="btn connect-gplus"><i class="ti-google"></i>使用微信登录</a></li>-->
                                <!--                        </ul>-->
                                <!--                    </div>-->
                                <!--                    <div class="devide-wrap"><span>OR</span></div>-->

                                <div class="login-form">
                                    <form>

                                        <div class="form-group">
                                            <label>电子邮箱</label>
                                            <div class="input-with-gray">
                                                <input id="emailID" type="text" class="form-control" placeholder="Email ID">
                                                <i class="ti-user theme-cl"></i>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>密码</label>
                                            <div class="input-with-gray">
                                                <input id="putin-password" type="password" class="form-control" placeholder="*******">
                                                <i class="ti-unlock theme-cl"></i>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <button id="login-submit" type="button" class="btn btn-primary btn-md full-width pop-login" disabled>登录
                                </button>
                                        </div>

                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <div class="mf-link"><i class="ti-user"></i>还没有账号？<a href="javascript:void(0)" data-toggle="modal" data-target="#signup" data-dismiss="modal">注册</a>
                                </div>
                                <div class="mf-forget"><a href="find-back-my-code.html"><i class="ti-help"></i>忘记密码？</a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Modal -->

                <!-- Sign Up Modal -->
                <div class="modal fade" id="signup" tabindex="-1" role="dialog" aria-labelledby="sign-up" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered login-pop-form" role="document">
                        <div class="modal-content" id="sign-up">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><i class="ti-close"></i></span>
                        </button>
                            </div>
                            <div class="modal-body">
                                <h4 class="modal-header-title">注册</h4>

                                <div class="col-lg-12 col-md-12 col-sm-12">
                                    <div class="nav nav-tabs col-lg-12 col-md-12 col-sm-12" style="display: inline-block; padding-left: inherit" id="signup-tab" role="tablist">
                                        <div class="nav-item">
                                            <a class="nav-link active" id="student-info-tab" data-toggle="pill" href="#student-info" role="tab" aria-controls="student-info" aria-selected="true">我是学生</a>
                                        </div>
                                        <div class="nav-item">
                                            <a class="nav-link" id="teacher-info-tab" data-toggle="pill" href="#teacher-info" role="tab" aria-controls="teacher-info" aria-selected="false">我是老师</a>
                                        </div>
                                    </div>
                                    <div class="tab-content" id="signup-tabContent">
                                        <div class="tab-pane fade show active" id="student-info" role="tabpanel" aria-labelledby="student-info-tab">
                                            <div class="login-form">
                                                <form>
                                                    <div class="row">
                                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                                            <div class="form-group">
                                                                <label>您的姓名</label>
                                                                <div class="input-with-gray">
                                                                    <input id="student-real-name" type="text" class="form-control" placeholder="您的姓名">
                                                                    <i class="ti-user theme-cl"></i>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                                            <div class="form-group">
                                                                <label>您的学号</label>
                                                                <div class="input-with-gray">
                                                                    <input id="student-id" type="text" class="form-control" placeholder="School ID">
                                                                    <i class="ti-user theme-cl"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="tab-pane fade" id="teacher-info" role="tabpanel" aria-labelledby="teacher-info-tab">
                                            <div class="login-form">
                                                <form>
                                                    <div class="row">
                                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                                            <div class="form-group">
                                                                <label>您的姓名</label>
                                                                <div class="input-with-gray">
                                                                    <input id="teacher-real-name" type="text" class="form-control" placeholder="您的姓名">
                                                                    <i class="ti-user theme-cl"></i>
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="col-lg-6 col-md-6 col-sm-6">
                                                            <div class="form-group">
                                                                <label>您的职工号</label>
                                                                <div class="input-with-gray">
                                                                    <input id="teacher-id" type="text" class="form-control" placeholder="School ID">
                                                                    <i class="ti-user theme-cl"></i>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label>电子邮箱</label>
                                                    <div class="input-with-gray">
                                                        <input id="email-id" type="text" class="form-control" placeholder="Email ID">
                                                        <i class="ti-user theme-cl"></i>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-12 col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label>设置密码</label>
                                                    <div class="input-with-gray">
                                                        <input id="set-password" type="password" class="form-control" placeholder="*******">
                                                        <i class="ti-unlock theme-cl"></i>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12 col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <button id="signup-submit" type="button" class="btn btn-primary btn-md full-width pop-login" disabled>注册
                                        </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <div class="mf-link"><i class="ti-user"></i>已有账户？<a href="javascript:void(0)" data-toggle="modal" data-target="#login" data-dismiss="modal">登录</a>
                                </div>
                                <div class="mf-forget"><a href="need-help.html"><i class="ti-help"></i>需要帮助</a></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Modal -->

            </div>
            <!-- ============================================================== -->
            <!-- End Wrapper -->
            <!-- ============================================================== -->

            <!-- ============================================================== -->
            <!-- All Jquery -->
            <!-- ============================================================== -->
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/popper.min.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>
            <script src="assets/js/select2.min.js"></script>
            <script src="assets/js/aos.js"></script>
            <script src="assets/js/perfect-scrollbar.jquery.min.js"></script>
            <script src="assets/js/owl.carousel.min.js"></script>
            <script src="assets/js/jquery.counterup.min.js"></script>
            <script src="assets/js/slick.js"></script>
            <script src="assets/js/bootstrap-datepicker.js"></script>
            <script src="assets/js/isotope.min.js"></script>
            <script src="assets/js/summernote.js"></script>
            <script src="assets/js/jQuery.style.switcher.js"></script>
            <script src="assets/js/counterup.min.js"></script>
            <script src="assets/js/custom.js"></script>
            <script>
                $(window).load(function() {
                    initData()
                });
            </script>
            <!-- ============================================================== -->
            <!-- This page plugins -->
            <!-- ============================================================== -->

        </body>

    </html>