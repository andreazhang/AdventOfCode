from utils import *

input = """7,1
11,1
11,7
9,7
9,5
2,5
2,3
7,3"""
# input = getInputData(9)

coordinates = []
for line in input.splitlines():
    parts = line.strip().split(',')
    coordinates.append((int(parts[0]), int(parts[1])))

print("Coordinates:", coordinates)

def calculateArea(c1, c2):
    return abs(c1[0] - c2[0] + 1) * abs(c1[1] - c2[1] + 1)

biggestArea = 0
for i in range(len(coordinates)):
    for j in range(i + 1, len(coordinates)):
        c1 = coordinates[i]
        c2 = coordinates[j]
        area = calculateArea(c1, c2)
        if area > biggestArea:
            biggestArea = area
        # print(f"Area between {c1} and {c2} is {area}")

print("Part 1: Biggest area is", biggestArea)
