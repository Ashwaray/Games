import os
import sys

print("         IIIT Allahabad                          ")
print("         B.TECH 7th SEMESTER PROJECT             ")
print("         By Ashwaray Raj Singh Chauhan           ")
print("         Project Mentor : Prof M. Radhakrishna   ")

from chesslib import board

# Load a save if it exists

if os.path.exists("state.fen"):
    with open("state.fen") as save:
        game = board.Board(save.read())
else:
    game = board.Board()

try:
    from chesslib.gui_console import display
finally:
    display(game)


