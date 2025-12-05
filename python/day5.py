from utils import *

input = """
3-5
10-14
16-20
12-18

1
5
8
11
17
32
"""
input = getInputData(5)

freshIngredientRanges = []
availableIngredients = set()

def extractInputIntoFreshIngredientRangesAndAvailableIngredients():
    for line in input.strip().splitlines():
        if line.strip() == "":
            continue
        if '-' in line:
            start, end = map(int, line.split('-'))
            freshIngredientRanges.append((start, end))
        else:
            availableIngredients.add(int(line))

extractInputIntoFreshIngredientRangesAndAvailableIngredients()

# print("Fresh Ingredient Ranges:", freshIngredientRanges)
# print("Available Ingredients:", availableIngredients)

def calculateNumberOfAvailableIngredientsInFreshIngredientRanges():
    usableIngredients = 0
    for ingredient in availableIngredients:
        for start, end in freshIngredientRanges:
            if start <= ingredient <= end:
                usableIngredients += 1
                break
    return usableIngredients

usableIngredients = calculateNumberOfAvailableIngredientsInFreshIngredientRanges()
print(f"Total usable ingredients: {usableIngredients}")

def mergeRangesThatHaveOverlap(ranges):
    for i, currentRange in enumerate(ranges):
        for j in range(i + 1, len(ranges)):
            nextRange = ranges[j]
            if currentRange[1] >= nextRange[0]:
                # print(" Merging:", currentRange, nextRange)
                mergedRange = (currentRange[0], max(currentRange[1], nextRange[1]))
                ranges[i] = mergedRange
                del ranges[j]
                return mergeRangesThatHaveOverlap(ranges)
    return ranges

freshIngredientRanges.sort()
mergedRanges = mergeRangesThatHaveOverlap(freshIngredientRanges)
# print("Merged Ranges:", mergedRanges)

totalFreshIngredients = 0
for start, end in mergedRanges:
    totalFreshIngredients += (end - start + 1)

print(f"Total fresh ingredients: {totalFreshIngredients}")