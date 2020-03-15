#include <iostream>

using namespace std;

int main()
{
    float item_cost = 0, paid = 0;
    cout << "Enter item cost: ";
    cin >> item_cost;
    cout << "Enter amount paid for item: ";
    cin >> paid;

    if (item_cost < 0 || paid < 0) {
        cout << "Invalid arguments: item cost and amount paid item cannot be negative." << endl;
    }

    else if (item_cost > paid) {
        cout << "Invalid arguments: amount paid for item must be greater or equal to item cost." << endl;
    }
    else {
        item_cost *= 100;
        paid *= 100;
        int item_cost_int = (int)item_cost;

        int paid_int = (int)paid;
        cout << item_cost_int<< ","<< paid_int << endl;
        paid_int -= item_cost_int;
        int nominals[] = { 50000,20000,10000,5000,2000,1000,500,200,100,50,20,10,5,2,1 };
        for (int i = 0; paid_int != 0 && i < 9; i++) {
            cout << (nominals[i] / 100) << "zl: " << (paid_int / nominals[i]) << endl;
            paid_int %= nominals[i];
        }
        for (int i = 9; paid_int != 0 && i < 15; i++) {
            cout << (nominals[i]) << "gr: " << (paid_int / nominals[i]) << endl;
            paid_int %= nominals[i];
        }
    }

    cin.get();

    return 0;
}