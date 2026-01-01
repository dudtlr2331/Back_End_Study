<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Title</title>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function (){
        // eq() / first() / last()
        // $('tr').eq(0).css('background-color', 'red');
        // $('tr').first().css('background-color', 'yellow');
        // $('tr').last().css('background-color', 'red');

        $('tr').eq(-1).css('background-color', 'red');


    });
</script>
</head>
<body>

<table width="500">
    <tr>
        <td>11</td>
        <td>12</td>
        <td>13</td>
    </tr>
    <tr>
        <td>21</td>
        <td>22</td>
        <td>23</td>
    </tr>
    <tr>
        <td>31</td>
        <td>32</td>
        <td>33</td>
    </tr>
    <tr>
        <td>41</td>
        <td>42</td>
        <td>43</td>
    </tr>
</table>

</body>
</html>