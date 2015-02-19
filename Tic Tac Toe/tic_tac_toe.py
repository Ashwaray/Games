import sys

class tic_tac_toe :
	
	def __init__ (self,a):
		for i in range(0,3):
			for j in range(0,5):
				if j%2 == 1:
					print '|',
				else :
					print '  ',
			print "\n",
	def game_(self,a):
		k =0
		for i in range(0,3):
			for j in range(0,5):
				if j%2 == 1:
					print '|',
				else:
					print a[k],
					k = k + 1
					print ' ' ,
			print '\n',
		
def change_player(player):
	if player == 1:
		player = 2
	else:
		player = 1

	return player


if __name__ == "__main__":
	a = [' ',' ',' ',' ',' ',' ',' ',' ',' ']
	game = tic_tac_toe(a)
	player = 1 
	chance = 9
	while chance > 0:
		print "player",
		print player,
		ink = raw_input("Enter your location : \n")
		inp = int(ink)
		if player == 1:
			a[inp] = 'X'
		else : 
			a[inp] = 'O'
		player = change_player(player)
		chance = chance - 1
		game.game_(a)
			
	char = 'X'

