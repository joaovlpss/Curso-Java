import calendar

nums = input('Enter the month and year separated by a comma (e.g., "9, 2023"): ')

mon, year = map(int, nums.split(','))  # Convert the input values to integers

cal = calendar.month(year, mon)  # Generate the calendar for the specified month and year

print(cal)
