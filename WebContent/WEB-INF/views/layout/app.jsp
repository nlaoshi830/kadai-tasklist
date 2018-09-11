<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>タスクリスト</title>
    </head>
    <body>
        <div id="warpper">
            <div id="header">
                <h1>Tasklist Application</h1>
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id = "footer">
                by Kohei Asano
            </div>
        </div>
    </body>
</html>