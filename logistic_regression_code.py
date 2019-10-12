

import subprocess
#subprocess.check_call(["python", '--version']) # install pkg
#subprocess.check_call(["python", '-m', 'pip', 'install','--ignore-installed', 'sklearn','--user']) # install pkg
#subprocess.check_call(["python", '-m', 'pip', 'install','--ignore-installed', 'seaborn','--user']) # install pkg
import numpy as np
import pandas as pd
import os
import sys
from matplotlib import pyplot as plt
from sklearn import preprocessing
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier
import seaborn as sns
import warnings
sns.set(style='white')
sns.set(style='whitegrid', color_codes=True)

def main(GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research):
    Computer_science_and_engineering=0.87
    Information_technology=0.86
    Software_engineering=0.86
    Communication_systems=0.85
    Wireless_communication=0.85
    Biometrics_and_cyber_security=0.80
    Computer_integrated_manufacturing=0.80
    Automotive_engineering=0.75
    Applied_electronics=0.75
    Bio_technology=0.74
    Industrial_engineering=0.72
    Industrial_metallurgy=0.72
    Energy_engineering=0.71
    Engineering_design=0.71
    Infrastructure_engineering=0.71
    Control_systems=0.69
    Embedded_and_real_time_systems=0.69
    Lean_manufacturing=0.65
    Power_electronics_and_drives=0.65
    Product_design_and_commerce=0.64
    Manufacturing_engineering=0.64
    Structural_engineering=0.64
    Virtual_prototyping_and_digital_manufacturing=0.62
    Vlsi_design=0.62
    Nano_technology=0.60
    Textile_technology=0.60

    
    
    df = pd.read_csv("/Users/mukea/NetBeansProjects/Logistic_regression_code/logistic_regression_code/Admission_Predict.csv")

    df.rename(columns = {'Chance of Admit ':'Chance of Admit', 'LOR ':'LOR'}, inplace=True)
    df.drop(labels='Serial No.', axis=1, inplace=True)
          
        
    targets = df['Chance of Admit']
    features = df.drop(columns = {'Chance of Admit'})

        
    X_train, X_test, y_train, y_test = train_test_split(features, targets, test_size=0.2, random_state=42)

    try :  
        y_train_binary = (y_train > Computer_science_and_engineering).astype(int)
        y_test_binary = (y_test > Computer_science_and_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        #data1=[310,40,10,0,20,10,10]
        #X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[data1])
        y_predict1 = logreg.predict(X_test1)

        
        
        y_train_binary = (y_train > Information_technology).astype(int)
        y_test_binary = (y_test > Information_technology).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Software_engineering).astype(int)
        y_test_binary = (y_test > Software_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Communication_systems).astype(int)
        y_test_binary = (y_test > Communication_systems).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Wireless_communication).astype(int)
        y_test_binary = (y_test > Wireless_communication).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Biometrics_and_cyber_security).astype(int)
        y_test_binary = (y_test > Biometrics_and_cyber_security).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Computer_integrated_manufacturing).astype(int)
        y_test_binary = (y_test > Computer_integrated_manufacturing).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Automotive_engineering).astype(int)
        y_test_binary = (y_test > Automotive_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Applied_electronics).astype(int)
        y_test_binary = (y_test > Applied_electronics).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Bio_technology).astype(int)
        y_test_binary = (y_test > Bio_technology).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Industrial_engineering).astype(int)
        y_test_binary = (y_test > Industrial_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Industrial_metallurgy).astype(int)
        y_test_binary = (y_test > Industrial_metallurgy).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Energy_engineering).astype(int)
        y_test_binary = (y_test > Energy_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Engineering_design).astype(int)
        y_test_binary = (y_test > Engineering_design).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Infrastructure_engineering).astype(int)
        y_test_binary = (y_test > Infrastructure_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Control_systems).astype(int)
        y_test_binary = (y_test > Control_systems).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Embedded_and_real_time_systems).astype(int)
        y_test_binary = (y_test > Embedded_and_real_time_systems).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Lean_manufacturing).astype(int)
        y_test_binary = (y_test > Lean_manufacturing).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Power_electronics_and_drives).astype(int)
        y_test_binary = (y_test > Power_electronics_and_drives).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Product_design_and_commerce).astype(int)
        y_test_binary = (y_test > Product_design_and_commerce).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Manufacturing_engineering).astype(int)
        y_test_binary = (y_test > Manufacturing_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Structural_engineering).astype(int)
        y_test_binary = (y_test > Structural_engineering).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Virtual_prototyping_and_digital_manufacturing).astype(int)
        y_test_binary = (y_test > Virtual_prototyping_and_digital_manufacturing).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Vlsi_design).astype(int)
        y_test_binary = (y_test > Vlsi_design).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Nano_technology).astype(int)
        y_test_binary = (y_test > Nano_technology).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
        
        
        
        y_train_binary = (y_train > Textile_technology).astype(int)
        y_test_binary = (y_test > Textile_technology).astype(int)
        logreg = LogisticRegression()
        logreg.fit(X_train, y_train_binary)
        y_predict = logreg.predict(X_test)
        logreg_score = (logreg.score(X_test, y_test_binary))*100
        X_test1 = pd.DataFrame(columns=["GRE Score","TOEFL Score","University Rating","SOP","LOR" ,"CGPA","Research"], data=[[GRE_Score,TOEFL_Score,University_Rating,SOP,LOR,CGPA,Research]])
        y_predict2 = logreg.predict(X_test1)
        y_predict1 = np.concatenate([y_predict1,y_predict2]) 
      
        print(y_predict1) 
    
    except Exception,e:
        print(e)
        
        
        
    
if __name__=="__main__":
    main(sys.argv[1],sys.argv[2],sys.argv[3],sys.argv[4],sys.argv[5],sys.argv[6],sys.argv[7])


    






