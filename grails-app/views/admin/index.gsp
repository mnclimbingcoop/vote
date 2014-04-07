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
                <h1 class="jumbotron">MNCC 2014 Board Seats - Administrative Options</h1>
            </div>

            <div class="panel panel-default">
                <div class="panel-body">
                    <ul>
                        <li>
                            <g:link action="members" id="${voteHash}"> Download List of Member </g:link>
                        </li>
                        <li>
                            <g:link action="votes" id="${voteHash}"> Download Voting Results </g:link>
                        </li>
                    </ul>
                </div>
                <g:uploadForm action="upload" id="${voteHash}">
                    <h2>Upload Members</h2>
                    <input type="file" name="members"/>
                    <br/>
                    <input type="submit" />
                    <p>Format</p>
                    <pre>
member_id,first_name,middle_name,last_name,suffix,email,member_since
                    </pre>
                    <p>Example</p>
                    <pre>
123,Aaron,J,Zirbes,,aaron.zirbes@mnclimbingcoop.com,2010-10-16
123,Ronald,,McDonald,Jr,ronald@mcdonalds.com,2012-10-16
123,Micah,Dyrud,,micah@thefuture.com,2010-10-16
</pre>
                </g:uploadForm>

                <div class="panel-footer">
                    <a href="http://mnclimbingcoop.com/">Back to the MNCC Home Page</a>
                </div>
            </div>
        </div>
    </body>
</html>
