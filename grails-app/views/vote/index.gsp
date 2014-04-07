<!DOCTYPE html>
<html lang="en" ng-app>
    <head>
        <meta charset="utf-8">
        <title>MNCC Board Vote</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <!-- Angular JS -->
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular.min.js"></script>
        <!-- Angular Animate -->
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.16/angular-animate.js"></script>
    </head>
    <body>
        <div class="container">
            <div  class="page-header">
                <h1 class="jumbotron">MNCC 2014 Board Seats</h1>
            </div>

            <div class="panel panel-default">
                <div class="panel-body">
                    <g:if test="${member}">
                    <g:if test="${member.vote}">Thanks for voting <b>${member.name}</b>!  See you at the Co-op.</g:if>
                        <g:else>
                        <div ng-app>
                            <g:form action="vote">
                            <g:hiddenField name="voteHash" value="${member.voteHash}"/>
                            <div class="check-element">
                                <g:checkBox ng-model="certified" name="certified"/>
                                I hearby certify that am 
                                <label for="certified">${member.name}</label>,
                                a member of the Minnesota Climbing Cooperative.
                            </div>
                            <div ng-show="certified">
                                <h2>The following Seats are up for vote</h2>
                                <ul class="list-unstyled">
                                    <li><g:checkBox name="liz" value="true"/>
                                        <label for="liz">   ${seats.liz}</label></li>
                                    <li><g:checkBox name="aaron" value="true"/>
                                        <label for="aaron"> ${seats.aaron}</label></li>
                                    <li><g:checkBox name="jim" value="true"/>
                                        <label for="jim">   ${seats.jim}</label></li>
                                    <li><g:checkBox name="jake" value="true"/>
                                        <label for="jake">  ${seats.jake}</label></li>
                                    <li><g:checkBox name="logan" value="true"/>
                                        <label for="logan"> ${seats.logan}</label> (interim)</li>
                                    <li><em>or</em></li>
                                    <li> <g:checkBox name="write" ng-model="write"/>
                                        <label for="write">Write In</label>
                                        <span ng-show="write"> : <g:textField name="writeIn"/> </span>
                                    </li>
                                </ul>
                                <g:submitButton name="Vote!"/>
                            </div>
                            </g:form>
                        </div>
                        </g:else>
                    </g:if>
                    <g:else>
                    <p> Sorry, we can't find you in our list of members!  </p>
                    </g:else>
                </div>
                <div class="panel-footer">
                    <a href="http://mnclimbingcoop.com/">Back to the MNCC Home Page</a>
                </div>
            </div>
        </div>
    </body>
</html>
