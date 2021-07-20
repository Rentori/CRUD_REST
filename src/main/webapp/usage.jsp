
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usage</title>
</head>
<body>
<h1 style="text-align: center;">Files</h1>
<p>get all:/v1/files</p>
<p>get by parameter: /v1/files?id=1</p>
<p>post, put, delete:&nbsp;</p>
<div>
    <div><span>{</span></div>
    <div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"id"</span><span>:</span><span>&nbsp;</span><span>1</span><span>,</span></div>
    <div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"name"</span><span>:</span><span>&nbsp;</span><span>"file"</span></div>
    <div><span>}</span></div>
    <div><span></span></div>
    <h1 style="text-align: center;"><span>Users</span></h1>
    <p>get all:/v1/users</p>
    <p>get by parameter: /v1/users?id=1</p>
    <p>post, put, delete:&nbsp;</p>
    <div>
        <div>
            <div>
                <div><span>{</span></div>
                <div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"id"</span><span>:</span><span>&nbsp;</span><span>1</span><span>,</span></div>
                <div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"first_name"</span><span>:</span><span>&nbsp;</span><span>"first"</span><span>,</span></div>
                <div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"last_name"</span><span>:</span><span>&nbsp;</span><span>"last"</span><span>,</span></div>
                <div><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"event_id"</span><span>:</span><span>&nbsp;</span><span>25</span></div>
                <div><span>}</span></div>
            </div>
        </div>
        <div>
            <h1 style="text-align: center;"><span>Events</span></h1>
            <p>get all:/v1/events</p>
            <p>get by parameter: /v1/events?id=1</p>
            <p>post, put, delete:&nbsp;</p>
            <div>
                <div>
                    <div><span>{</span></div>
                    <div><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"id"</span><span>:</span><span>&nbsp;</span><span>1</span><span>,</span></div>
                    <div><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"name"</span><span>:</span><span>&nbsp;</span><span>"event"</span><span>,</span></div>
                    <div><span>&nbsp;&nbsp;&nbsp;&nbsp;</span><span>"file_id"</span><span>:</span><span>&nbsp;</span><span>35</span></div>
                    <div><span>}</span></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
