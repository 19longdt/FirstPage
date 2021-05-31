<%-- 
    Document   : SteveJobs
    Created on : 11-Mar-2021, 18:20:06
    Author     : hp
--%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
    @import url(https://fonts.googleapis.com/css?family=Open+Sans);

    *{
        box-sizing:border-box;
    }
    html, body{
        height:100%;
        font: normal 1em/1.5 "Open Sans";
        background-color:#ddd;
        background-size:cover;
    }
/*    a{
        color:#ccc;
    }*/
    .con{
        width:700px;
        min-height:315px;
        margin: 0 auto;
        position:relative;
        padding-bottom:30px;
        overflow:hidden;
    }
    h1{
        text-align:center;
        text-shadow:0 1px white;
        color:#02303F;
    }
    h2{
        color:#343a40; 
        margin:15px 0 5px;
        text-shadow:0 1px rgba(255,255,255,0.5);
    }
    h6{
        color:#928566; 
        margin:0;
    }
    input[type="radio"] {
        position: absolute;
        width: 1px; /* Setting this to 0 make it invisible for VoiceOver */
        height: 1px; /* Setting this to 0 make it invisible for VoiceOver */
        padding: 0;
        margin: -1px;
        border: 0;
        clip: rect(0 0 0 0);
        overflow: hidden;
    }
    .l1a{
        display:block;
        /*width:32%;*/
        border: 4px solid white;
        /*position: static;*/
        bottom:5px;
        cursor: pointer;
        transition: border-color 0.3s linear;
    }

    .l1a.second{
        left:34%;
    }
    .l1a.third{
        left:68%;
    }

    blockquote{
        margin:0;
        padding:30px;
        width:700px;
        background-color: #bbbbbb;
        color:white;
        box-shadow: 0 5px 2px rgba(0,0,0,0.1);
        position:relative;
        transition: background-color 0.6s linear;
    }

    blockquote:after { 
        content: " "; 
        height: 0; 
        width: 0; 
        position: absolute; 
        top: 100%; 
        border: solid transparent; 
        border-top-color: #bbbbbb;
        border-left-color:#bbbbbb;
        border-width: 10px; 
        left: 10%; 
    } 
    #second:checked ~ .two blockquote {
        background-color: #92967d;
    }
    .two blockquote:after{
        border: solid transparent; 
        border-top-color: #92967d;
        border-left-color: #92967d;
        border-width: 10px;
    }
    #third:checked ~ .three blockquote{
        background-color:#343a40!important;
    }
    .three blockquote:after{
        border: solid transparent; 
        border-top-color: #343a40;
        border-left-color: #343a40;
        border-width: 10px;
    }
    .quotes{
        position:absolute;
        color:rgba(255,255,255,0.5);
        font-size:5em;
    }
    .leftq{
        top:-25px;
        left:5px;
    }
    .rightq{
        bottom:-10px;
        right:5px;
    }
    img{
/*        float:left;
        margin-right: 20px;*/
    }
    .slide{
        position:absolute;
        left:-100%;
        opacity:0;
        transition: all 0.6s ease-in;
    }

    #first:checked ~ l1a.first {
        border-width:6px;
        border-color:#bbbbbb;
    }
    #second:checked ~ l1a.second {
        border-width:6px; border-color: #92967d;
    }
    #third:checked ~ l1a.third {
        border:6px solid #343a40!important;
    }

    #first:checked ~ div.one {
        left:0;
        opacity:1;
    }
    #second:checked ~ div.two {
        left:0;
        opacity:1;
    }
    #third:checked ~ div.three {
        left:0;
        opacity:1;
    }

</style>
<div class="con">
    
    <input type="radio" name="nav" id="first" checked/>
<!--    <input type="radio" name="nav" id="second" />
    <input type="radio" name="nav" id="third" />-->

    <!--<p class="l1a" for="first" class="first"></p>-->
<!--    <p class="l1a" for="second"  class="second"></p>
    <p  class="l1a" for="third" class="third"></p>-->

    <div class="one slide">
        <blockquote>
            <span class="leftq quotes">&ldquo;</span> That's been one of my mantras - focus and simplicity. Simple can be harder than complex; you have to work hard to get your thinking clean to make it simple.                                            <span class="rightq quotes">&bdquo; </span>
        </blockquote>
        <img src="https://static.ybox.vn/2017/12/23/a64bbe0c-e7a9-11e7-b05b-56c566ee3692.jpg" width="230" height="150" />
        <h2>Steve Jobs</h2>
        <h6> Time </h6>
    </div>

<!--    <div class="two slide">
        <blockquote>
            <span class="leftq quotes">&ldquo;</span>The only way to do great work is to love what you do...</span>
        </blockquote>
        <img src="https://upload.wikimedia.org/wikipedia/commons/d/dc/Steve_Jobs_Headshot_2010-CROP_%28cropped_2%29.jpg" width="270" height="180" />
        <h2>Steve Jobs</h2>
        <h6>Critical Thinking</h6>
    </div>

    <div class="three slide">
        <blockquote>
            <span class="quotes leftq"> &ldquo;</span> Even if we lose our money, we'll have a company. For once in our lives, we'll have a company. <span class="rightq quotes">&bdquo; </span>
        </blockquote>
        <img src="https://hri.com.vn/wp-content/uploads/bfi_thumb/1-1-olan434kkb0rgqsxa58ok4n0umrtvyf2q3n1pfxjme.jpg" width="320" height="160" />
        <h2>Steve Jobs</h2>
        <h6>Creation</h6>
    </div>-->


</div> 
