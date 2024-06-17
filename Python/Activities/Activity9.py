# Given list of numbers
numList1 = [10, 20, 23, 11, 17]
numList2 = [13, 43, 24, 36, 12]
print("Given list is ", numList1, numList2)

# Declare a third list that will contain the result
thirdList = []
 
# Iterate through first list to get odd elements
for num in numList1:
    if (num % 2 != 0):
        thirdList.append(num)
        
# Iterate through first list to get even elements
for num in numList2:
    if (num % 2 == 0):
        thirdList.append(num)
 
# Print result
print("result List is:")
print(thirdList)

