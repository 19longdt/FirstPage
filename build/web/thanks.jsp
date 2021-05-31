<%-- 
    Document   : thanks
    Created on : 21-Mar-2021, 15:35:03
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png"
              type ="image/x-icon">
        <title>Thank You | Apple Store</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            /* this is a fork from Chris: https://codepen.io/chrisyboy53/pen/xzYvZz * thank you Chris */

            .hb-wrapper {
                background-color: white;
                color: black;
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
            }

            .hb-wrapper h1 {
                position: absolute;
                top: 30%;
                left: calc(50vw - 150px);
                z-index: 9999;
                font-family: 'Cabin', sans-serif;
                font-size: 3em;
                color: #343a40!important;
                text-shadow: 0 0 10px #ccc;
            }
            #h{
                text-align: center;
            }
/*            body{
                 background-color: gray;
            }*/
        </style>

    </head>
    <body>


        <div id="hb-wrapper" class="hb-wrapper">
            <img src="https://i.pinimg.com/originals/77/c3/66/77c366436d8bd35fe8b3ce5b8c66992e.png" width="60px" height="60px" />
            <a id="h" href="out">APPLE STORE</a>
            <h1>Thank You!</h1>
        </div>

    </body>
    <script>
        var rnd = Math.random,
                flr = Math.floor;

        let canvas = document.createElement('canvas');
        document.getElementById('hb-wrapper').appendChild(canvas);
        canvas.style.position = 'absolute';
        canvas.style.width = '100%';
        canvas.style.height = '100%';

        canvas.width = canvas.clientWidth;
        canvas.height = canvas.clientHeight;

        let ctx = canvas.getContext('2d');

        function rndNum(num) {
            return rnd() * num + 1;
        }

        function vector(x, y) {
            this.x = x;
            this.y = y;

            this.add = function (vec2) {
                this.x = this.x + vec2.x;
                this.y = this.y + vec2.y;
            }
        }

        function particle(pos, vel) {
            this.pos = new vector(pos.x, pos.y);
            this.vel = vel;
            this.dead = false;
            this.start = 0;

            this.update = function (time) {
                let timeSpan = time - this.start;

                if (timeSpan > 500) {
                    this.dead = true;
                }

                if (!this.dead) {
                    this.pos.add(this.vel);
                    this.vel.y = this.vel.y + gravity;
                }
            };

            this.draw = function () {
                if (!this.dead) {
                    drawDot(this.pos.x, this.pos.y, 1);
                }
            }

        }

        function firework(x, y) {

            this.pos = new vector(x, y);
            this.vel = new vector(0, -rndNum(10) - 3);
            this.color = 'hsl(' + rndNum(360) + ', 100%, 50%)'
            this.size = 4;
            this.dead = false;
            this.start = 0;
            let exParticles = [],
                    exPLen = 100;

            let rootShow = true;

            this.update = function (time) {
                if (this.dead) {
                    return;
                }

                rootShow = this.vel.y < 0;

                if (rootShow) {
                    this.pos.add(this.vel);
                    this.vel.y = this.vel.y + gravity;
                } else {
                    if (exParticles.length === 0) {
                        flash = true;
                        for (let i = 0; i < exPLen; i++) {
                            exParticles.push(new particle(this.pos, new vector(-rndNum(10) + 5, -rndNum(10) + 5)));
                            exParticles[exParticles.length - 1].start = time;
                        }
                    }
                    let numOfDead = 0;
                    for (let i = 0; i < exPLen; i++) {
                        let p = exParticles[i];
                        p.update(time);
                        if (p.dead) {
                            numOfDead++;
                        }
                    }

                    if (numOfDead === exPLen) {
                        this.dead = true;
                    }

                }
            }

            this.draw = function () {
                if (this.dead) {
                    return;
                }

                ctx.fillStyle = this.color;
                if (rootShow) {
                    drawDot(this.pos.x, this.pos.y, this.size);
                } else {
                    for (let i = 0; i < exPLen; i++) {
                        let p = exParticles[i];
                        p.draw();
                    }
                }
            }

        }

        function drawDot(x, y, size) {
            ctx.beginPath();

            ctx.arc(x, y, size, 0, Math.PI * 2);
            ctx.fill();

            ctx.closePath();
        }

        var fireworks = [],
                gravity = 0.2,
                snapTime = 0,
                flash = false;

        function init() {
            let numOfFireworks = 20;
            for (let i = 0; i < numOfFireworks; i++) {
                fireworks.push(new firework(rndNum(canvas.width), canvas.height));
            }
        }

        function update(time) {
            for (let i = 0, len = fireworks.length; i < len; i++) {
                let p = fireworks[i];
                p.update(time);
            }
        }

        function draw(time) {
            update(time);

            ctx.fillStyle = 'rgba(255,255,255,0.3)';
            if (flash) {
                flash = false;
            }
            ctx.fillRect(0, 0, canvas.width, canvas.height);

            ctx.fillStyle = 'white';
            ctx.font = "30px Arial";
            let newTime = time - snapTime;
            snapTime = time;

            //ctx.fillText(newTime,10,50);

            ctx.fillStyle = 'blue';
            for (let i = 0, len = fireworks.length; i < len; i++) {
                let p = fireworks[i];
                if (p.dead) {
                    fireworks[i] = new firework(rndNum(canvas.width), canvas.height);
                    p = fireworks[i];
                    p.start = time;
                }
                p.draw();
            }

            window.requestAnimationFrame(draw);
        }

        window.addEventListener('resize', function () {
            canvas.width = canvas.clientWidth;
            canvas.height = canvas.clientHeight;
        });

        init();
        draw();

    </script>
</html>
