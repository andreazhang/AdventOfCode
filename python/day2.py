from utils import *
import re

input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124"
inputRanges = input.split(',')

fullInput = getInputData(2)
inputRanges = fullInput.split(',')

invalidIdSum = 0


def isInvalidID(id):
    id = str(id)
    if (id.__len__() % 2 != 0):
        return False

    halfLength = int(id.__len__() / 2)
    if (id[:halfLength] != id[halfLength:]):
        return False
    return True


def isInvalidIDRegex(id):
    id = str(id)
    return re.match(r"(\d+)\1{1,}$", id)


for inputRange in inputRanges:
    startRange = int(inputRange.split('-')[0])
    endRange = int(inputRange.split('-')[1])
    print(f'{startRange} -- {endRange}')
    for i in range(startRange, endRange+1):
        if isInvalidIDRegex(i):
            invalidIdSum += i
            print(i)

print(f"output: {invalidIdSum}")
