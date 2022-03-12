<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Home</title>
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
        
        <div class="content">
            <!-- welcome -->
            <div class="row content-home">
                <div class="col-9">
                    <c:forEach var="postEle" items="${listAllPost}">
	                    <div class="welcome">
	                        <h4 class="title">${postEle.title}</h4>
	                        <p class="date-up">Posted by ${postEle.getUserEntity().userName} on ${postEle.createTime}</p>
	                        <p>${postEle.content}</p>
	                        <div class="tag-infor-update">
	                            <p><strong>Tags:</strong>  <a href="">${postEle.tags}</a></p>
	                            <c:if test = "${postEle.updateTime!= Null}">
	                               <p><a href="#">Permalink</a> | <a id="link-cmt" href="#">Comments ${postEle.getStPost().size()}</a> | Last updated on ${postEle.updateTime}</p>
	                            </c:if>
	                            <c:if test = "${postEle.updateTime == Null}">
                                   <p><a href="">Permalink</a> | <a id="link-cmt" href="#">Comments ${postEle.getStPost().size()}</a></p>
                                </c:if>
	                            
	                            
	                        </div>
	                        
                               
	                        <div class="container block-cmt">
	                               <c:forEach var="comment" items="${listAllComment}">
                                      <c:if test="${comment.postEntity.id == postEle.id }">
	                                    <div class="my-comment">
	                                           <small>
	                                               <span style="font-weight: 500;">Author:</span> ${comment.author} |
	                                           </small>
	                                           
	                                           <small>
	                                               <span style="font-weight: 500;">Email:</span> ${comment.email} |
	                                           </small>
	                                           
	                                           <small>
	                                               <span style="font-weight: 500;">Create Time: </span> ${comment.createTime}
	                                           </small>
	                                           <h6>Comment</h6>
	                                           <p>${comment.content}</p>
	                                    </div>
                                     </c:if>
                                  </c:forEach>
                                    <form action="saveComment" method="post" modelAttribute="commentAttr">
                                        <input type="hidden" name="postID" value="${postEle.id}" class="form-control" >
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Email Address</label>
                                            <input type="email" name="email" class="form-control" style="width:100%" >
                                            <small id="emailErr" class="form-text text-muted"></small>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Author</label>
                                            <input type="text" name="author" class="form-control" style="width:100%" >
                                            <small id="authorErr" class="form-text text-muted"></small>
                                        </div>
                            
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Url</label>
                                            <input type="text" name="url" class="form-control" style="width:100%">
                                            <small id="urlErr" class="form-text text-muted"></small>
                                        </div>
                            
                                        <div class="form-group">
                                            <label for="exampleInputEmail1">Content</label>
                                            <textarea name="content" class="form-control"  cols="66" rows="6" style="resize:none"></textarea>
                                            <small id="emailHelp" class="form-text text-muted"></small>
                                        </div>
                            
                                        <button type="submit" class="btn btn-primary">Comment</button>
                                    </form>

                                </div>
                                
	                    </div>
	                    
	           
                    </c:forEach>
                    <div class="mt-3">
                        <nav aria-label="Page navigation example">
	                        <ul class="pagination">
	                           <c:if test = "${indexPage==1}">
	                               <li class="page-item disabled"><a class="page-link" href="http://localhost:8080/JSFW.L.A102.Blogs/home?index=${previous}">Previous</a></li>
	                           </c:if>
	                           <c:if test = "${indexPage>1}">
                                   <li class="page-item"><a class="page-link" href="http://localhost:8080/JSFW.L.A102.Blogs/home?index=${previous}">Previous</a></li>
                               </c:if>
	                            
	                            <c:forEach begin = "1" end ="${numberPage}" var="i">
	                               <li class="page-item"><a class="page-link" href="http://localhost:8080/JSFW.L.A102.Blogs/home?index=${i}">${i}</a></li>
	                            </c:forEach>
	                            
	                            <c:if test = "${indexPage==numberPage}">
	                               <li class="page-item disabled" ><a class="page-link" href="http://localhost:8080/JSFW.L.A102.Blogs/home?index=${next}">Next</a></li>
	                            </c:if>
	                            
	                            <c:if test = "${indexPage<numberPage}">
                                   <li class="page-item" ><a class="page-link" href="http://localhost:8080/JSFW.L.A102.Blogs/home?index=${next}">Next</a></li>
                                </c:if>
	                            
	                        </ul>
                        </nav>  
                    </div>
                    
                </div>
                <c:if test = "${sessionScope.userLogin.userName == Null}">
                    <div class="col-3">
	                    <div class="tag-infor-update">
	                        <p class="tags">Tags</p>
	                        <p><a href="">blog test</a></p>
	                    </div>
	                    <div class="tag-infor-update">
	                        <p class="tags">recent comments</p>
	                        <p>Tester on <a href="">A Test Post</a></p>
	                    </div>
                    </div>
                </c:if>
                
                 <c:if test = "${sessionScope.userLogin.userName != Null}">
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
                </c:if>
                
            </div>

        <div class="Footer">
            <p>Copyright©2016 by My Company</p>
            <p>All rights reserved</p>
        </div>

    </div>
    </div>
    
    <script type="text/javascript" src="<c:url value="/js/all.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.6.0.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/comment1.js"/>"></script>
</body>
</html>