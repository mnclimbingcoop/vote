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
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    </head>
    <body>
        <h1>MNCC 2014 Board Seats</h1>
        <g:if test="${member}">
            <g:if test="${member.vote}">Thanks for voting!  See you at the Co-op.</g:if>
            <g:else>
                <p>The following Seats are up for vote</p>
                <g:form action="vote">
                <g:hidden name="member.id" value="${member.id}"/>
                <g:hidden name="member.voteHash" value="${member.voteHash}"/>
                <ul>
                    <li><g:checkbox name="liz">${seat.liz}</g:checkbox></li>
                </ul>
                </g:form>
            </g:else>
        </g:if>
        <g:else>
        <p> Sorry, we can't find you in our list of members!  </p>
        </g:else>
        <footer>
            <a href="http://mnclimbingcoop.com/">Back to the MNCC Home Page</a>
        </footer>
    </body>
</html>
