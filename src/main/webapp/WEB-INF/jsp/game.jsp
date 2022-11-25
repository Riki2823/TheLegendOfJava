<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
    
        <style>
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            canvas{
                border: 3px solid black;
                margin: 5%;
            }


        </style>
    </head>
    <body>
        <h1>Bienvenido al Mapa ${mapId}</h1>

        <p>
            Room: ${actualRoom}
        </p>
        <p>Coins: ${coinsU}</p>
        <p>${messageWall}</p>
        <div id=canvaContainer>
            <canvas id="game" width="700" height="700"></canvas>
            <form id="dirForm" method="get" action="/nav">
                <input id="dir" name="dir" type="hidden"></input>
            </form>
            <form id="coinForm" method="get" action="/getCoin"></form>
            <form id="keyForm" method="get" action="/getKey"></form>

        </div>

        <script type = "application/json" id="roomData">
            ${room}
        </script>

        <script>
            let canvas = document.getElementById('game');
            let ctx = canvas.getContext('2d');


            let roomString = document.getElementById("roomData").innerHTML;
            roomString = roomString.replace(";", "");
            console.log(roomString);
            let room = JSON.parse(roomString);
            drawRoom(room);

            let brujula = new Image();
            brujula.src = '/img/brujula.jpg';

            brujula.onload = function(){
                ctx.drawImage(brujula, 500, 500, 200, 200);
            }

           
            let sprite = new Image();
            sprite.src ='/img/pokemon_sprite.png';

            sprite.onload = function(){
                ctx.drawImage(sprite, 100, 0, 60, 60, 300, 300, 60, 60);
            }
            let spriteX = 300;
            let spriteY = 300;

            canvas.addEventListener("click", (event) => {
            
                let rect = canvas.getBoundingClientRect();
                let x = event.clientX - rect.left;
                let y = event.clientY - rect.top;

                console.log(x, y);

                if (x > 519 && x < 535){
                    if(y > 594 && y < 604){
                        moveWest();
                    }
                }

                if (x > 596 && x < 607){
                    if(y > 524 && y < 534){
                        moveNorth();
                    }
                }

                if (x > 667 && x < 676){
                    if(y > 594 && y < 605){
                        moveEast();
                    
                    }
                }

                if (x > 598 && x < 610){
                    if(y > 664 && y < 678){
                       moveSouth();
                    }
                }
                
                if (room.items.coin){
                    if (x >195 && x < 218){
                        if (y > 363 && y < 392){
                            document.getElementById("coinForm").submit();
                            ctx.clearRect(180, 350, 50, 50);
                        }
                    }
                 
                }
                if (room.items.key){
                    if(x > 456 && x < 491){
                        if(y > 354 && y < 398){
                            document.getElementById("keyForm").submit();
                            ctx.clearRect(450, 350, 50, 50);
                        }
                    }
                    
                }
            });
            
            let feet = true;
            function moveWest(){
                document.getElementById("dir").value = "w";
                document.getElementById("dirForm").submit();
                console.log(room.walls.west);
            }
            function moveNorth(){
                document.getElementById("dir").value = "n";
                document.getElementById("dirForm").submit();
                console.log(room.walls.north);
            }
            function moveEast(){
                document.getElementById("dir").value = "e";
                document.getElementById("dirForm").submit();
                console.log(room.walls.east);
            }
            function moveSouth(){
                document.getElementById("dir").value = "s";
                document.getElementById("dirForm").submit();
                console.log(room.walls.south);
            }

            function drawRoom(room){
                ctx.fillStyle = 'black';
                ctx.fillRect(100, 100, 500, 400);
                ctx.fillStyle = 'white';
                ctx.fillRect(150, 150, 400, 300);
                if (room.items.coin){
                    drawCoin();
                }
                if(room.items.key){
                    drawKey();
                }
               

            }
            
            function drawKey(){
                let key = new Image();
                key.src = '/img/key.png';

                key.onload = function() {
                    ctx.drawImage(key, 450, 350, 50, 50);
                }
            }

            function drawCoin(){
                console.log("coin")
                let coin = new Image();
                coin.src = '/img/coin.png';

                coin.onload = function() {
                   ctx.drawImage(coin, 180, 350, 50, 50);
                };


            }
        </script>
    </body>
</html>