#include<iostream>
using namespace std;
void HF1(int **,int *);
void HF2(int **,int *);
void HF3(int **,int *);


int sumProbes(int **);
int H2(int);


int main(){
    int keys[]={
            1234,8234,7867,1009,5438,4312,3420,9487,5418,5299,
            5078,8239,1208,5098,5195,5329,4543,3344,7698,5412,
            5567,5672,7934,1254,6091,8732,3095,1975,3843,5589,
            5439,8907,4097,3096,4310,5298,9156,3895,6673,7871,
            5787,9289,4553,7822,8755,3398,6774,8289,7665,5523
    };

    int ch;
    do{
        int **Table=new int*[50];
        for(int i=0;i<50;i++)
        {
            Table[i]=new int[2];
            Table[i][0] = -1;
            Table[i][1] = 0;
        }
        cout<<"------MAIN MENU-----"<<endl;
        cout<<"0 - Exit Program "<<endl;
        cout<<"1 - Run HF1 (Division method with Linear Probing)"<<endl;
        cout<<"2 - Run HF2 (Division method with Quadratic Probing)"<<endl;
        cout<<"3 - Run HF3 (Division method with Double Hashing)"<<endl;
        cin>>ch;
        if(ch == 1){
            cout<<"Index    Keys     Probes"<<endl;
            cout<<"------------------------"<<endl;
            HF1(Table,keys);
            cout<<"Sum of probe values = "<<sumProbes(Table)<<endl;
        }
        else if(ch == 2){
            cout<<"Index    Keys     Probes"<<endl;
            cout<<"------------------------"<<endl;
            HF2(Table,keys);
            cout<<"Sum of probe values = "<<sumProbes(Table)<<endl;

        }
        else if(ch == 3){
            cout<<"Index    Keys     Probes"<<endl;
            cout<<"------------------------"<<endl;
            HF3(Table,keys);
            cout<<"Sum of probe values = "<<sumProbes(Table)<<endl;
        }
        else {
            cout<<"Invalid Choice "<<endl;
        }

    }while(ch !=0 );
    return 0;
}
void HF1(int **Table,int keys[]){

    for (int i = 0; i < 50; i++)
    {
        // Computing the hash value
        int hash_value = keys[i] % 50;

        // Insert in the Table if there is no collision
        if (Table[hash_value][0] == -1){
            Table[hash_value][0] = keys[i];

        }
        else
        {
            // If there is a collision iterating through all possible quadratic values
            int probes=0;
            for (int j = 0; j < 50; j++)
            {
                int temp = (keys[i] + j) % 50;
                if (Table[temp][0] == -1)
                {
                    Table[temp][0] = keys[i];
                    Table[temp][1] = probes;
                    break;
                }
                probes++;
            }
        }
    }
    for(int hash_value = 0;hash_value<50;hash_value++){
        cout<<hash_value<<"       "<<Table[hash_value][0]<<"       "<<Table[hash_value][1]<<endl;

    }
}

void HF2(int **Table,int keys[]){

    for (int i = 0; i < 50; i++)
    {
        int hash_value = keys[i] % 50;
        if (Table[hash_value][0] == -1){
            Table[hash_value][0] = keys[i];
        }

        else
        {
            // If there is a collision iterating through all possible quadratic values
            int probes=0;
            for (int j = 0; j < 50; j++)
            {
                // Computing the new hash value
                int temp = (keys[i] + j * j) % 50;
                if (Table[temp][0] == -1)
                {
                    Table[temp][0] = keys[i];
                    Table[temp][1] = probes;
                    break;
                }
                probes++;
            }
        }
    }
    for(int hash_value = 0;hash_value<50;hash_value++){
        cout<<hash_value<<"       "<<Table[hash_value][0]<<"       "<<Table[hash_value][1]<<endl;

    }
}


int H2(int key){
    return (30-(key%25));
}

void HF3(int **Table,int keys[]){

    for (int i = 0; i < 50; i++)
    {
        int hash_value = (keys[i] % 50) + ((0) * H2(keys[i]));

        if (Table[hash_value][0] == -1){
            Table[hash_value][0] = keys[i];
        }

        else
        {
            int probes=0;
            int j=1;
            while (j <= 50) {
                hash_value = (keys[i] % 50) + ((j) * H2(keys[i]));
                if ( hash_value < 50 && Table[hash_value][0] == -1 ) {
                    Table[hash_value][0] = keys[i];
                    Table[hash_value][1] = probes;

                    break;
                }
                j++;
                probes++;
            }
            if(j > 50){
                cout<<endl<<"Unable to hash key "<<keys[i]<<" to the table "<<endl;
            }

        }
    }
    for(int hash_value = 0;hash_value<50;hash_value++){
        if(Table[hash_value][0] != -1)
            cout<<hash_value<<"       "<<Table[hash_value][0]<<"       "<<Table[hash_value][1]<<endl;

    }

}

int sumProbes(int **Table){
    int totalProbes=0;

    for(int i=0;i<50;i++){
        totalProbes += Table[i][1];
    }
    return totalProbes;
}