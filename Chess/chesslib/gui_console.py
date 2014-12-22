# -*- encoding: utf-8 -*-
import board
import os
import voice
import speech_recognition as sr

UNICODE_PIECES = {
  'r': u'♜', 'n': u'♞', 'b': u'♝', 'q': u'♛',
  'k': u'♚', 'p': u'♟', 'R': u'♖', 'N': u'♘',
  'B': u'♗', 'Q': u'♕', 'K': u'♔', 'P': u'♙',
  None: ' '
}

class BoardGuiConsole(object):
    error = ''
    def voi_func(self):
        voice_in = ""
        r = sr.Recognizer()
        with sr.Microphone() as source:                # use the default microphone as the audio source
            print("---------Say Your Move------- \n")        
            audio = r.listen(source)                   # listen for the first phrase and extract it into audio data

        try:
            voice_in = r.recognize(audio)
            k = voice_in
            print("You said " + r.recognize(audio))    # recognize speech using HMM
            #l = k[0:2]+k[3:5]
            #print(l)
            l = ""
            t = k[0]
            if t == "1":
               l = l+"a"
            elif t == "2":
               l = l + "b"
            elif t == "3":
                l = l + "c"
            elif t == "4":
               l = l + "d"
            elif t == "5":
                l = l + "e"
            elif t == "6":
               l = l + "f"
            elif t == "7":
                l = l + "g"
            elif t == "8":
               l = l + "h"


            l = l + k[1]
            t = k[2]

            if t == "1":
               l = l+"a"
            elif t == "2":
               l = l + "b"
            elif t == "3":
                l = l + "c"
            elif t == "4":
               l = l + "d"
            elif t == "5":
                l = l + "e"
            elif t == "6":
               l = l + "f"
            elif t == "7":
                l = l + "g"
            elif t == "8":
               l = l + "h"
           
            l = l + k[3]
            print(l)
            if k == "exit":
                return k
            
            return l

        except LookupError:                            # speech is unintelligible
            print("Could not understand audio")
        return ""
    
    def __init__(self, chessboard):
        self.board = chessboard

    def move(self):
        os.system("clear")
        self.unicode_representation()
        print "\n", self.error
        print "State a move in chess notation (e.g.for A2A3 say 2 2 2 3). Type \"exit\" to leave:\n", ">>>",
        print "\nA=1, B=2, C=3, D=4, E=5, F=6, G=7, H=8"
        self.error = ''
        #coord = raw_input()
        #coord = self.voi_func()
        for chance_chalo in range (1,200):
            coord = self.voi_func()
            if len(coord) % 4 == 0:
                break
            
        if coord == "exit":
            print "Bye."
            exit(0)
        try:
            if len(coord) != 4: raise board.InvalidCoord
            self.board.move(coord[0:2], coord[2:4])
            print "\n" * 100
            os.system("clear")
        except board.ChessError as error:
            self.error = "Error: %s" % error.__class__.__name__

        self.move()

    def unicode_representation(self):
        print(" IIIT ALLAHABAD   PROJECT PRESENTATION  ")
       
        print "\n", ("%s's turn\n" % self.board.player_turn.capitalize()).center(28)
        for number in self.board.axis_x[::-1]:
            print " " + str(number) + " ",
            for letter in self.board.axis_y:
                piece = self.board[letter+str(number)]
                if piece is not None:
                    print UNICODE_PIECES[piece.abbriviation] + '    ',
                else: print '      ',
            print "\n"
        print '    ' + '      '.join(self.board.axis_y)

def display(board):
    try:
        gui = BoardGuiConsole(board)
        gui.move()
    except (KeyboardInterrupt, EOFError):
        os.system("clear")
        exit(0)
