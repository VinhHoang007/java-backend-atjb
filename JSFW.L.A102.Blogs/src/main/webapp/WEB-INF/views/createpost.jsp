<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
        <%@include file="/css/all.css"%>
        <%@include file="/css/bootstrap.min.css"%>
        <%@include file="/css/fStyle.css"%>
    </style>
<title>Create Post</title>
</head>
<body>
    <div class="container-fluid row">
        <div class="container-title Header col-12">
            <h2>Blog</h2>
        </div>
        <div class="col-12 container-navigation Navigation-menu">
            <ul>
                <li class="home"><a class="text-white text-decoration-none" href="<c:url value="/home"/>">Home</a></li>
                <li class="about"><a class="text-white text-decoration-none" href="<c:url value="/about"/>">About</a></li>
                <li class="contact"><a class="text-white text-decoration-none" href="<c:url value="/contact"/>">Contact</a></li>
                <c:if test = "${sessionScope.userLogin.userName != Null}">
                    <li class="login"><a class="text-white text-decoration-none" href="<c:url value="/logout"/>">Logout ${sessionScope.userLogin.userName}</a></li>
                </c:if>
                <c:if test = "${sessionScope.userLogin.userName == Null}">
                    <li class="login"><a class="text-white text-decoration-none" href="<c:url value="/login"/>">Login</a></li>
                </c:if>  
            </ul>
        </div>
        
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><class="text-decoration-none" href="<c:url value="/home"/>">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Create Post</li>
            </ol>
        </nav>
        
        <div class="content">
            
             <div class="row content-create-post">
                <div class="col-9 pl-3">
                     <h3 class="title">Create post</h3>
                     <p>Fields with <span class="requid">*</span> are required</p>
                     <form action="savePost" method="post" modelAttribute="postSave">
                         <div class="form-group form-create-post">
                            <label for="">Title <span class="requid">*</span></label>
                            <input type="text" name="title" id="" class="form-control" >
                            <label for="">Content <span class="requid">*</span></label>
                            <textarea name="content" id="" cols="66" rows="6"></textarea>
                            <small id="helpId" class="text-muted">You may use <a href="">Markdown systax</a></small>
                            <label for="">Tags</label>
                            <input type="text" name="tags" id="" style="width: 66%;" class="form-control" >
                            <small id="helpId" class="text-muted">Please separate different tags with commas.</small>
                            <label for="">Status <span class="requid">*</span></label>
                            <select style="width: 20%;" class="mb-3" name="status" id="">
                                <option value="Draft">Draft</option>
                                <option value="Public">Public</option>
                                <option value="Outdated">Outdated</option>
                            </select>
                            <button>Create</button>
                         </div>
                     </form>
                </div>
                <div class="col-3">
                    <div class="tag-infor-update">
                        <p class="tags">Demo</p>
                        <p><a href="<c:url value="/post/showCreatePost"/>">Create New Post</a></p>
                        <p><a href="<c:url value="/post/showManagePost"/>">Manage Posts</a></p>
                        <p><a href="#">Approve Comments</a> <small class="text-muted">(0)</small> </p>
                        <p><a href="<c:url value="/logout"/>">Logout ${sessionScope.userLogin.userName}</a></p>
                    </div>
                    <div class="tag-infor-update">
                        <p class="tags">tags</p>
                        <p><a href="">blog</a> <a href=""> test</a></p>
                    </div>
                    <div class="tag-infor-update">
                        <p class="tags">recent comments</p>
                        <p>Tester on <a href="">A Test Post</a></p>
                    </div>
                </div>

             </div>
             
            </div>
              
        </div>

        <div class="Footer">
            <p>Copyright©2016 by My Company</p>
            <p>All rights reserved</p>
        </div>

    
    
    <script type="text/javascript" src="<c:url value="/js/all.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
    

</body>
</html>