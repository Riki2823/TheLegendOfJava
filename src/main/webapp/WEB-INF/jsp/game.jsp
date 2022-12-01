<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>TheLegendOfJava</title>
        <link rel="stylesheet" href="../../styles/game.css">
    </head>
    <body>
        <main>
            
            <div id=canvaContainer>

                <p id="title">Bienvenido al Mapa ${mapId}<p>
                <p>Room: ${actualRoom}</p>
                <p>Coins: ${coinsU}</p>
                <p>${messageWall}</p>
                <canvas id="game" width="700" height="700"></canvas>
                <form id="dirForm" method="get" action="/nav">
                    <input id="dir" name="dir" type="hidden"></input>
                </form>
                <form id="coinForm" method="get" action="/getCoin"></form>
                <form id="keyForm" method="get" action="/getKey"></form>
                <form id="openForm" method="get"action="/open">
                    <input id="dirO" name="dir" type="hidden"></input>
                </form>
                <form action="/endform" method="get" id="winForm"></form>
                <button>Reset Game</button>   
            </div>
    
        </main>
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

            if("${winner}" == "true"){
                let win = new Image;
                win.src = '/img/win.png';

                win.onload = function(){
                    ctx.drawImage(win, 200, 100, 300, 300);
                }
                
                setTimeout(() => {
                    document.getElementById("winForm").submit();            
                }, 3000)
            }

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
            
            
            function moveWest(){
                if(room.walls.west == "doorclosed"){
                    document.getElementById("dirO").value = "w";
                    document.getElementById("openForm").submit();
                }else{
                    document.getElementById("dir").value = "w";
                    document.getElementById("dirForm").submit();
                }
                
                console.log(room.walls.west);
            }
            function moveNorth(){
                if(room.walls.north == "doorclosed"){
                    document.getElementById("dirO").value = "n";
                    document.getElementById("openForm").submit();
                }else{
                    document.getElementById("dir").value = "n";
                    document.getElementById("dirForm").submit();
                }
                
                console.log(room.walls.north);
            }
            function moveEast(){
                if(room.walls.east == "doorclosed"){
                    document.getElementById("dirO").value = "e";
                    document.getElementById("openForm").submit();
                }else{
                    document.getElementById("dir").value = "e";
                    document.getElementById("dirForm").submit();
                }
                
                console.log(room.walls.east);
            }
            function moveSouth(){
                if(room.walls.south == "doorclosed"){
                    document.getElementById("dirO").value = "s";
                    document.getElementById("openForm").submit();
                }else{
                    document.getElementById("dir").value = "s";
                    document.getElementById("dirForm").submit();
                }
                
                console.log(room.walls.south);
            }

            function drawRoom(room){
                ctx.fillStyle = 'white';
                ctx.fillRect(100, 100, 500, 400);
                ctx.fillStyle = 'black';
                ctx.fillRect(150, 150, 400, 300);
                if (room.items.coin){
                    drawCoin();
                }
                if(room.items.key){
                    drawKey();
                }

                if(room.walls.north == "door"){
                    ctx.fillStyle = 'black';
                    ctx.fillRect(310, 100, 60, 60);
                }
                if(room.walls.south == "door"){
                    ctx.fillStyle = 'black';
                    ctx.fillRect(310, 450, 60, 60);
                }
                if(room.walls.west == "door"){
                    ctx.fillStyle = 'black';
                    ctx.fillRect(100, 310, 60, 60);
                }
                if(room.walls.east == "door"){
                    ctx.fillStyle = 'black';
                    ctx.fillRect(550, 310, 60, 60);
                }


                if(room.walls.north == "doorclosed"){
                    ctx.fillStyle = 'red';
                    ctx.fillRect(310, 100, 50, 60);
                }
                if(room.walls.south == "doorclosed"){
                    ctx.fillStyle = 'red';
                    ctx.fillRect(310, 450, 50, 60);
                }
                if(room.walls.west == "doorclosed"){
                    ctx.fillStyle = 'red';
                    ctx.fillRect(100, 310, 50, 60);
                }
                if(room.walls.east == "doorclosed"){
                    ctx.fillStyle = 'red';
                    ctx.fillRect(550, 310, 50, 60);
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