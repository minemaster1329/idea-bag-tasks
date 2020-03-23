def check_format(number):
    try:
        num = float(number)
        return True
    except ValueError:
        return False


cost = 0
paid = 0
cost_str = input("Enter item cost: ").replace(',', '.')
paid_str = input("Enter amount paid for item: ").replace(',', '.')
if check_format(cost_str) and check_format(paid_str):
    cost = float(cost_str)
    paid = float(paid_str)
    if cost > paid:
        print("Amount paid for item must be greater or equal to cost.")
    else:
        cost = int(cost * 100)
        paid = int(paid * 100)
        paid -= cost
        tab = [50000, 20000, 10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1]
        for a in range(0, 9):
            count = int(paid / tab[a])
            print((tab[a] / 100), "zl: ", count)
            paid -= count * tab[a]

        for a in range(9, 15):
            count = int(paid / tab[a])
            print((tab[a]), "gr: ", count)
            paid -= count * tab[a]

else:
    print("One of given numbers is not valid")
