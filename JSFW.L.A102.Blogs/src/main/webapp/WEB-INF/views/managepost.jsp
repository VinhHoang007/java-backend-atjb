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
<title>Manage Post</title>
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
                <li class="breadcrumb-item"><a class="text-decoration-none" href="<c:url value="/home"/>">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Manage Post</li>
            </ol>
        </nav>

        <div class="content">

            <div class="row content-manager-post">
                <div class="col-9 pl-3">
                    <h3 class="title">Create post</h3>
                    <p class="text-right">Displaying 1-2 of <span class="resutl">2</span> result(s)</p>
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Status</th>
                                <th>Create Time</th>
                                <th>*</th>
                            </tr>
                        </thead>
                        <tbody class="data-post">
                            <tr>
                             <form action="searchPost" method ="get" modelAttribute = "searchTitle">
                                <td scope="row">
                                        <input name="title" style="width: 160px;" type="text">                
                                </td>
                                <td>
                                    <select style="width: 100px;" name="status" id="">
                                        <option value="Draft">Draft</option>
                                        <option value="Public">Public</option>
                                        <option value="Outdated">Outdated</option>
                                    </select>
                                </td>
                              </form>   
                            </tr>
                            <c:if test="${listPostSearch == Null}">
                                <!-- Data -->
                            <!-- loop over and print our customers -->
                            <c:forEach var="postEle" items="${listPost}">
                            <tr>
                                    <c:url var="searchLink" value="/home">
                                    <c:param name="postID" value="${postEle.id}" />
                                    </c:url>
                                    
                                    <c:url var="updateLink" value="/post/showUpdatePost">
                                    <c:param name="postID" value="${postEle.id}" />
                                    </c:url>
                                    
                                    <c:url var="deleteLink" value="/post/deletePost">
                                    <c:param name="postID" value="${postEle.id}" />                                    
                                    </c:url> 
                                <td scope="row"><a href="">${postEle.title}</a></td>
                                <td> ${postEle.status}</td>
                                <td> ${postEle.createTime}</td>
                                <td class="d-flex btn-func">
                                    <a style="color: gray;" href="${searchLink}">            
                                    <i class="fas fa-search"></i>
                                    </a>
                                    
                                   <a style="color: cadetblue;" href="${updateLink}" class="ml-3 mr-3">
                                    <i class="fas fa-pen"></i>
                                    </a>
                                    
                                    <a style="color: brown;" href="${deleteLink}"
                                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
                                    <i class="fas fa-times"></i>                       
                                   </a>                  
                                    
                                </td>
                            </tr>
                             </c:forEach>
                            </c:if>
                            
                            <c:if test="${listPostSearch != Null}">
                                <c:forEach var="postEle" items="${listPostSearch}">
                            <tr>
                                    <c:url var="searchLink" value="/home">
                                    <c:param name="postID" value="${postEle.id}" />
                                    </c:url>
                                    
                                    <c:url var="updateLink" value="/post/showUpdatePost">
                                    <c:param name="postID" value="${postEle.id}" />
                                    </c:url>
                                    
                                    <c:url var="deleteLink" value="/post/deletePost">
                                    <c:param name="postID" value="${postEle.id}" />                                    
                                    </c:url> 
                                <td scope="row"><a href="">${postEle.title}</a></td>
                                <td> ${postEle.status}</td>
                                <td> ${postEle.createTime}</td>
                                <td class="d-flex btn-func">
                                    <a style="color: gray;" href="${searchLink}">            
                                    <i class="fas fa-search"></i>
                                    </a>
                                    
                                   <a style="color: cadetblue;" href="${updateLink}" class="ml-3 mr-3">
                                    <i class="fas fa-pen"></i>
                                    </a>
                                    
                                    <a style="color: brown;" href="${deleteLink}"
                                    onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">
                                    <i class="fas fa-times"></i>                       
                                   </a>                  
                                    
                                </td>
                            </tr>
                             </c:forEach>
                            </c:if>
                            
                        </tbody>
                    </table>
                </div>
                <div class="col-3">
                    <div class="tag-infor-update">
                        <p class="tags">Demo</p>
                        <p><a href="<c:url value="/post/showCreatePost"/>">Create New Post</a></p>
                        <p><a href="<c:url value="/post/showManagePost"/>">Manage Posts</a></p>
                        <p><a href="#">Approve Comments</a> <small class="text-muted">(0)</small> </p>
                        <p><a href="<c:url value="/logout"/>">Logout</a></p>
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

        <div class="Footer">
            <p>Copyright©2016 by My Company</p>
            <p>All rights reserved</p>
        </div>

    </div>

    <script type="text/javascript" src="<c:url value="/js/all.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>

   
</body>
</html>