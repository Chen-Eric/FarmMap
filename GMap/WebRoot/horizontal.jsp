<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Kwicks Horizontal Example</title>

        <link rel='stylesheet' type='text/css' href='../jquery.kwicks.css' />
        <style type='text/css'>
            .kwicks {
                width: 515px;
                height: 100px;
            }
            .kwicks > li {
                width: 125px;
                height: 100px;
                /* overridden by kwicks but good for when JavaScript is disabled */
                margin-left: 5px;
                float: left;
            }

            #panel-1 { background-color: #53b388; }
            #panel-2 { background-color: #5a69a9; }
            #panel-3 { background-color: #c26468; }
            #panel-4 { background-color: #bf7cc7; }
        </style>
    </head>

    <body>
        <ul class='kwicks kwicks-horizontal'>
            <li id='panel-1'></li>
            <li id='panel-2'></li>
            <li id='panel-3'></li>
            <li id='panel-4'></li>
        </ul>

        <script src='js/jquery-1.8.1.min.js' type='text/javascript'></script>
        <script src='../jquery.kwicks.js' type='text/javascript'></script>

        <script type='text/javascript'>
            $().ready(function() {
                $('.kwicks').kwicks({
                    size: 125,
                    maxSize : 250,
                    spacing : 5,
                    behavior: 'menu'
                });
            });
        </script>
    </body>
</html>