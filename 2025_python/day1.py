from utils import *

input = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82
"""
input = getInputData(1)

dialTurnCommands = input.splitlines()

dial = 50 # starting position
dialSize = 100 # size of the dial (0 to 99)

zeroOccurrencesAtDialTurnEnd = 0
zeroOccurrencesDuringDialTurn = 0

for command in dialTurnCommands:
    turnDirection = command[0]
    turnValue = int(command[1:])
    for i in range(turnValue):
        if turnDirection == 'L':
            dial -= 1
        else:
            dial += 1
        if dial < 0:
            dial += dialSize
        elif dial >= dialSize:
            dial -= dialSize
        if dial == 0:
            zeroOccurrencesDuringDialTurn += 1
    if dial == 0:
        zeroOccurrencesAtDialTurnEnd += 1

print("Part 1:", zeroOccurrencesAtDialTurnEnd)
print("Part 2:", zeroOccurrencesDuringDialTurn)
