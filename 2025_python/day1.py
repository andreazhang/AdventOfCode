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

fullInput = getInputData(1)

dial = 50

commands = fullInput.splitlines()

zeroOccurrences = 0

for command in commands:
    direction = command[0]
    turnValue = int(command[1:])
    while turnValue > 0:
        if direction == 'L':
            dial -= 1
        else:
            dial += 1
        if dial < 0:
            dial += 100
        elif dial > 99:
            dial -= 100
        if dial == 0:
            zeroOccurrences += 1
        turnValue -= 1

print(zeroOccurrences)
