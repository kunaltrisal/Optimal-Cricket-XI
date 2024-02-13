package com.company;
import java.util.*;

public class Dream11 {
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        Object [][] data= new Object[22][4];    //heterogenous array i.e Array of Objects
        System.out.println("Enter Team 1: ");
        for(int i=0;i<11;i++)                   //Team 1 entered
        {
            System.out.print((i+1) + ". ");
            data[i][0]= sc.nextLine();
        }
        System.out.println("Enter Team 2: ");
        for(int i=11;i<=21;i++)                //Team 2 entered
        {
            System.out.print((i-10) + ".");
            data[i][0]= sc.nextLine();
        }
        //All players have 4 points, 0 runs and 0 wickets by default
        for(int i=0;i<data.length;i++)
        {
            data[i][1]=4;
            data[i][2]=0;
            data[i][3]=0;
        }

        System.out.println("FIRST INNINGS BEGINS!");
        System.out.println("Openers: ");
        int i=0,j=1;
        System.out.println(data[i][0]);
        System.out.println(data[j][0]);
        int si=1,sj=0;                  //for strike change

        System.out.println("Enter (index+10) to select bowler: ");            //Select opening Bowler
        for(int z=11;z<=21;z++)                                 //Displaying bowling team for bowler selection
        {
            System.out.println((z-10) + ". " + data[z][0]);
        }
        int b= sc.nextInt();                      //Bowler index selected

        //FIRST INNINGS BEGINS!.....................................................................................
        for(int k=1;k<=18;k++)
        {
            if(si==1)                                          //For displaying batsman on strike
            {
                System.out.println("On strike: " + data[i][0]);
            }
            else if(sj==1)
            {
                System.out.println("On strike: " + data[j][0]);
            }

            //Ball
            System.out.println("Press 0 for dot ball");
            System.out.println("Press 1 for 1 run");
            System.out.println("Press 2 for 2 runs");
            System.out.println("Press 3 for 3 runs");
            System.out.println("Press 4 for 4 runs");
            System.out.println("Press 6 for 6 runs");
            System.out.println("Press -1 for a wicket");
            int x= sc.nextInt();                        //Result of the ball

            if(x==1 || x==3)
            {
                if(si==1 && x==1)
                {
                    data[i][1]= (int)data[i][1]+ 1;     // column 1 is for points
                    data[i][2]= (int)data[i][2]+ 1;     //column 2 is for scores
                    si=0;
                    sj=1;
                }
                else if(si==1 && x==3)
                {
                    data[i][1]= (int)data[i][1]+ 3;     // column 1 is for points
                    data[i][2]= (int)data[i][2]+ 3;     //column 2 is for scores
                    si=0;
                    sj=1;
                }
                else if(sj==1 && x==1)
                {
                    data[j][1]= (int)data[j][1]+ 1;     // column 1 is for points
                    data[j][2]= (int)data[j][2]+ 1;     //column 2 is for scores
                    si=1;
                    sj=0;
                }
                else if(sj==1 && x==3)
                {
                    data[j][1]= (int)data[j][1]+ 3;     // column 1 is for points
                    data[j][2]= (int)data[j][2]+ 3;     //column 2 is for scores
                    si=1;
                    sj=0;
                }
            }
            else if(x==2)                   //scoring for 2 runs
            {
                if(si==1)
                {
                    data[i][1]= (int)data[i][1]+ 2;     //points added
                    data[i][2]= (int)data[i][1]+ 2;     //score added
                }
                else if(sj==1)
                {
                    data[j][1]= (int)data[j][1]+ 2;     //points added
                    data[j][2]= (int)data[j][1]+ 2;     //score added
                }
            }
            else if(x==4)                   //Scoring for boundary
            {
                if(si==1)
                {
                    data[i][1]= (int)data[i][1]+ 5;     //points added
                    data[i][2]= (int)data[i][1]+ 4;     //score added
                }
                else if(sj==1)
                {
                    data[j][1]= (int)data[j][1]+ 5;     //points added
                    data[j][2]= (int)data[j][1]+ 4;     //score added
                }
            }
            else if(x==6)                               //scoring for 6 runs
            {
                if(si==1)
                {
                    data[i][1]= (int)data[i][1]+ 8;     //points added
                    data[i][2]= (int)data[i][1]+ 6;     //score added
                }
                else if(sj==1)
                {
                    data[j][1]= (int)data[j][1]+ 8;     //points added
                    data[j][2]= (int)data[j][1]+ 6;     //score added
                }
            }
            else if(x==-1)                              //scoring for a wicket
            {
                System.out.println("Catch or bowled? y/n: ");
                char ch= sc.next().charAt(0);
                if(ch=='y')                   //if catch or bowled out
                {
                    data[b][3]= (int)data[b][3] + 1;    //wicket added
                    data[b][1]= (int)data[b][1] + 33;   //points added
                }
                else
                {
                    data[b][3]= (int)data[b][3] + 1;    //wicket added
                    data[b][1]= (int)data[b][1] + 25;   //points added
                }

                if(si==1)           //if i has strike
                {
                    System.out.println(data[i][0] + " OUT!");
                    if(i<j)
                    {
                        i=j+1;
                        System.out.println("Next batsman in: " + data[i][0]);
                    }
                    else
                    {
                        i=i+1;
                        System.out.println("Next batsman in: " + data[i][0]);
                    }
                }
                if(sj==1)           //if j has strike
                {
                    System.out.println(data[j][0] + " OUT!");
                    if(j<i)
                    {
                        j=i+1;
                        System.out.println("Next batsman in: " + data[j][0]);
                    }
                    else
                    {
                        j=j+1;
                        System.out.println("Next batsman in: " + data[j][0]);
                    }
                }
            }
            if(k==18)                          //END OF THE INNINGS
            {
                System.out.println("First Innings over!");
                break;
            }
            if(k%6==0)              //Over ends
            {
                System.out.println("Over.");
                System.out.println("Select (index+10) to select new bowler: ");            //New Bowler
                for(int z=11;z<=21;z++)                         //Displaying bowling team for bowler selection
                {
                    System.out.println((z-10) + ". " + data[z][0]);
                }
                b= sc.nextInt();
                if(si==1)               //if i on strike at the end of over
                {
                    si=0;
                    sj=1;
                }
                else if(sj==1)          //if j on strike  at the end of over
                {
                    sj=0;
                    si=1;
                }
            }
        }
        System.out.println("END OF 1st INNINGS...............................................");

        System.out.println("SECOND INNINGS BEGINS!");
        System.out.println("Openers: ");
        i=11;
        j=12;
        System.out.println(data[i][0]);                         //Displaying openers
        System.out.println(data[j][0]);
        si=1;                            //for strike change
        sj=0;

        System.out.println("Select index to select bowler: ");            //Select opening Bowler
        for(int z=1;z<=11;z++)                                 //Displaying bowling team for bowler selection
        {
            System.out.println(z + ". " + data[z][0]);
        }
        b= sc.nextInt()-1;                      //Bowler index selected

        //SECOND INNINGS BEGINS!.....................................................................................
        for(int k=1;k<=18;k++)                                 //Number of overs to be bowled
        {
            if(si==1)                                          //For displaying batsman on strike
            {
                System.out.println("On strike: " + data[i][0]);
            }
            else if(sj==1)
            {
                System.out.println("On strike: " + data[j][0]);
            }

            //Ball
            System.out.println("Press 0 for dot ball");
            System.out.println("Press 1 for 1 run");
            System.out.println("Press 2 for 2 runs");
            System.out.println("Press 3 for 3 runs");
            System.out.println("Press 4 for 4 runs");
            System.out.println("Press 6 for 6 runs");
            System.out.println("Press -1 for a wicket");
            int x= sc.nextInt();                        //Result of the ball

            if(x==1 || x==3)
            {
                if(si==1 && x==1)
                {
                    data[i][1]= (int)data[i][1]+ 1;     // column 1 is for points
                    data[i][2]= (int)data[i][2]+ 1;     //column 2 is for scores
                    si=0;
                    sj=1;
                }
                else if(si==1 && x==3)
                {
                    data[i][1]= (int)data[i][1]+ 3;     // column 1 is for points
                    data[i][2]= (int)data[i][2]+ 3;     //column 2 is for scores
                    si=0;
                    sj=1;
                }
                else if(sj==1 && x==1)
                {
                    data[j][1]= (int)data[j][1]+ 1;     // column 1 is for points
                    data[j][2]= (int)data[j][2]+ 1;     //column 2 is for scores
                    si=1;
                    sj=0;
                }
                else if(sj==1 && x==3)
                {
                    data[j][1]= (int)data[j][1]+ 3;     // column 1 is for points
                    data[j][2]= (int)data[j][2]+ 3;     //column 2 is for scores
                    si=1;
                    sj=0;
                }
            }
            else if(x==2)                   //scoring for 2 runs
            {
                if(si==1)
                {
                    data[i][1]= (int)data[i][1]+ 2;     //points added
                    data[i][2]= (int)data[i][1]+ 2;     //score added
                }
                else if(sj==1)
                {
                    data[j][1]= (int)data[j][1]+ 2;     //points added
                    data[j][2]= (int)data[j][1]+ 2;     //score added
                }
            }
            else if(x==4)                   //Scoring for boundary
            {
                if(si==1)
                {
                    data[i][1]= (int)data[i][1]+ 5;     //points added
                    data[i][2]= (int)data[i][1]+ 4;     //score added
                }
                else if(sj==1)
                {
                    data[j][1]= (int)data[j][1]+ 5;     //points added
                    data[j][2]= (int)data[j][1]+ 4;     //score added
                }
            }
            else if(x==6)                               //scoring for 6 runs
            {
                if(si==1)
                {
                    data[i][1]= (int)data[i][1]+ 8;     //points added
                    data[i][2]= (int)data[i][1]+ 6;     //score added
                }
                else if(sj==1)
                {
                    data[j][1]= (int)data[j][1]+ 8;     //points added
                    data[j][2]= (int)data[j][1]+ 6;     //score added
                }
            }
            else if(x==-1)                              //scoring for a wicket
            {
                System.out.println("Catch or bowled? y/n: ");
                char ch= sc.next().charAt(0);
                if(ch=='y')                   //if catch or bowled out
                {
                    data[b][3]= (int)data[b][3] + 1;    //wicket added
                    data[b][1]= (int)data[b][1] + 33;   //points added
                }
                else
                {
                    data[b][3]= (int)data[b][3] + 1;    //wicket added
                    data[b][1]= (int)data[b][1] + 25;   //points added
                }

                if(si==1)           //if i has strike
                {
                    System.out.println(data[i][0] + " OUT!");
                    if(i<j)
                    {
                        i=j+1;
                        System.out.println("Next batsman in: " + data[i][0]);
                    }
                    else
                    {
                        i=i+1;
                        System.out.println("Next batsman in: " + data[i][0]);
                    }
                }
                if(sj==1)           //if j has strike
                {
                    System.out.println(data[j][0] + " OUT!");
                    if(j<i)
                    {
                        j=i+1;
                        System.out.println("Next batsman in: " + data[j][0]);
                    }
                    else
                    {
                        j=j+1;
                        System.out.println("Next batsman in: " + data[j][0]);
                    }
                }
            }
            if(k==18)                          //END OF THE INNINGS
            {
                System.out.println("Second Innings over!");
                break;
            }
            if(k%6==0)              //Over ends
            {
                System.out.println("Over.");
                System.out.println("Select index to select new bowler: ");            //New Bowler
                for(int z=1;z<=11;z++)                         //Displaying bowling team for bowler selection
                {
                    System.out.println(z + ". " + data[z][0]);
                }
                b= sc.nextInt()-1;
                if(si==1)               //if i on strike at the end of over
                {
                    si=0;
                    sj=1;
                }
                else if(sj==1)          //if j on strike  at the end of over
                {
                    sj=0;
                    si=1;
                }
            }
        }
        System.out.println("END OF 2nd INNINGS........................................");
        System.out.println("Name      Pts    Score     Wickets");
        for(int a=0;a<22;a++)               //displaying the heterogenous array
        {
            for(int c=0;c<4;c++)
            {
                System.out.print(data[a][c] + "     ");
            }
            System.out.println();
        }
        //......................Ending Display Code: .........................
        int [] arr= new int[22];
        for(int p=0;p<22;p++)
        {
            arr[p]= (int)data[p][1];
        }
        Arrays.sort(arr);
        System.out.println("DREAM TEAM: ");
        for(int p=21;p>=11;p--)             //traversing from last
        {
            for(int l=0;l<22;l++)           //traversing heterogenous array
            {
                if(arr[p]==(int)data[l][1])
                {
                    System.out.println(data[l][0]);         //displays the dream team!
                    break;
                }
            }
        }
    }
}