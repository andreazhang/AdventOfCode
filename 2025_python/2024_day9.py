from utils import *

input = "2333133121414131402"
# input = getInputData(9, 2024)

digits = list(map(int, input.strip()))

fileIndex = 0
diskMap = []

print(digits)
print(len(digits))

for index, digit in enumerate(digits):
    if index % 2 == 0:
        diskMap.extend([fileIndex] * digit)
        fileIndex += 1
    else:
        diskMap += "." * digit

print("--- Disk Map ---")
print(diskMap)

j = 0
length = len(diskMap)
numberOfDots = diskMap.count('.')
for i in range(len(diskMap) - 1, 1, -2):
    if diskMap[i] == '.':
        continue
    print(i, diskMap[i], diskMap.count(diskMap[i]), "ah")
    i -= diskMap.count(diskMap[i])

print("--- Sorted Disk Map ---")
print(diskMap)

checksum = 0

for index, digit in enumerate(diskMap):
    if digit == '.':
        continue
    checksum += digit * index
    # print(f"{digit} * {index} = {digit * index}")

print(length)
print(numberOfDots)
print(len(diskMap))
print(f"sum: {checksum}")
# Expected: 1928

# 6430446922192




# part 1
# for index, digit in enumerate(digits):
#     if index % 2 == 0:
#         diskMap.extend([fileIndex] * digit)
#         fileIndex += 1
#     else:
#         diskMap += "." * digit

# print("--- Disk Map ---")
# print(diskMap)

# j = len(diskMap) - 1
# length = len(diskMap)
# numberOfDots = diskMap.count('.')
# for i in range(len(diskMap) - numberOfDots - 1):
#     if diskMap[i] != '.':
#         continue
#     while diskMap[j] == '.':
#         j -= 1
#     diskMap[i] = diskMap[j]
#     diskMap[j] = '.'
#     j -= 1

# print("--- Sorted Disk Map ---")
# print(diskMap)

# checksum = 0

# for index, digit in enumerate(diskMap):
#     if digit == '.':
#         continue
#     checksum += digit * index
#     # print(f"{digit} * {index} = {digit * index}")

# print(length)
# print(numberOfDots)
# print(len(diskMap))
# print(f"sum: {checksum}")
# # Expected: 1928

# # 6430446922192