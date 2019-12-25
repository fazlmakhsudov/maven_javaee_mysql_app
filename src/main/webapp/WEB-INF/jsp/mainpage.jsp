<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <style>
        aside {
            float: left;
            margin-right: 75px;
            font-size: 54px;
            text-decoration: none;
        }
        a:hover {
          color: orange;
          background-color: green;
        }
        h1 {
            color: red;
            font-style: italic;
            font-size: large;
            animation-name: animation;
            animation-duration: 10s;
            animation-iteration-count: 3;
        }
   @keyframes animation {
     from {
       transform: translate(10px, 12px);
       color: yellow;
     }
     50% {
       top: 5%;
       left: 15%;
       color: green;
       font-size: 400%;
     }
     60% {
       top: 50%;
       left: 50%;
        transform: translate(10px, 12px);
       color: brown;
     }
     75% {
       top: 75px;
       color: lightBlue;
     }
     to {
       top: 100%;
       right: 100%;
     }
   }
    </style>
</head>
<body>
    <aside>
        <ul>
            <li><a href="html?url=registration.html">Registration</a></li>
            <li><a href="html?url=login_.html">Login</a></li>
        </ul>
    </aside>
    <h1>${actionResult}</h1>
</body>
</html>