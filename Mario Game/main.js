var game = new Phaser.Game(1500, 500, Phaser.CANVAS, 'gameDiv');
var count =0;
var mainState = {

    preload: function() { 
        game.load.image('bg','images/bg.png');
        game.load.image('player', 'images/player.png');  
        game.load.image('pipe', 'images/pipe.png');    
    },

    create: function() { 
        this.bg= this.game.add.sprite(0,0,'bg'); 
        game.physics.startSystem(Phaser.Physics.ARCADE);
        this.player = this.game.add.sprite(100, 245, 'player');     
        game.physics.arcade.enable(this.player);//enabling physical attributes (logan_611)
        this.player.body.gravity.y = 1000; //adding gravity sothat player can fall

        // Call the 'jump' function when the spacekey is hit
        var spaceKey = this.game.input.keyboard.addKey(Phaser.Keyboard.SPACEBAR);
        spaceKey.onDown.add(this.jump, this); 

        this.pipes = game.add.group();
        this.pipes.enableBody = true;
        this.pipes.createMultiple(500, 'pipe');  

        // Timer that calls 'addRowOfPipes' ever 1.5 seconds
        this.timer = this.game.time.events.loop(1500, this.addRowOfPipes, this);           

        this.score = 0;//score
        var scr = "score = ";
        this.scr =this.game.add.text(10,50,scr,{ font: "30px Arial", fill: "#000000" });  
        this.labelScore = this.game.add.text(135, 50, "0", { font: "30px Arial", fill: "#000000" });  
    },

    update: function() {
        // If the player is too high or too low, call the 'restartGame' function
        if (this.player.inWorld == false)
            this.restartGame(); 

        // If the player overlap any pipes, call 'restartGame'
        game.physics.arcade.overlap(this.player, this.pipes, this.restartGame, null, this);      
    },

    jump: function() {
        this.player.body.velocity.y = -350;
    },
    
    restartGame: function() {
        // Start the 'main' state, which restarts the game
        game.state.start('main');
    },

    addOnePipe: function(x, y) {
        var pipe = this.pipes.getFirstDead();

        // Set the new position of the pipe
        pipe.reset(x, y);

        // Add velocity to the pipe to make it move left and up
        var k = this.score/10;
        var t = 20;
        pipe.body.velocity.x = -200-(k*50); 
        if(count % 25 == 0){
            t = t*(-1);
        }else{
            count++;
        }
        pipe.body.velocity.y = t;  
        pipe.checkWorldBounds = true;
        pipe.outOfBoundsKill = true;
    },

    // Add a row of 6 pipes with a hole somewhere in the middle
    addRowOfPipes: function() {
        var k = this.score;
        var hole = Math.floor(Math.random()*5)+1;
        if(k >= 0 && k<=50){
            for (var i = 0; i < 25; i++)
                if (i != hole && i != hole +1 && i!=hole+6 && i!= hole+5) 
                    this.addOnePipe(1500, i*60+10); 
        }else{
            this.restartGame();  
        }
    
        this.score += 1;
        this.labelScore.text = this.score;  
    },
};

// Add and start the 'main' state to start the game
game.state.add('main', mainState);  
game.state.start('main');
