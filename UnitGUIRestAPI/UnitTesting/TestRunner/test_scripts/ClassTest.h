#ifndef CLASSTEST_H
#define CLASSTEST_H


#define TESTING 1

#include<iostream>
#include<fstream>
#include<iomanip>
#include<string>
#include<stdlib.h>
#include<stdio.h>

using namespace std;


class Testpoints {
   static Testpoints *instance;
   int data,d_spec,p_dep;
   string p_pass, p_x;
 
   // Private constructor so that no objects can be created.
   Testpoints() {
      data = 0;
      d_spec =0;
      p_dep = 0;
      p_pass = "";
      p_x = "";
   }

   public:
   int object=0;
   static Testpoints *getInstance() {
   
      if (!instance)
      {
      	instance = new Testpoints;
      }
      	return instance;
      
   }
   
   int getP_dep(){
   	return this ->p_dep;
   	}
   
   void setP_dep(int dep)
   {
   	this -> p_dep = dep;
   }
   
   int getD_spec() {
   	return this -> d_spec;
   	}
   	
   void setD_spec(int spec) {
      this -> d_spec = spec;
   }

   string getP_pass() {
      return this -> p_pass;
   }

   void setP_pass(string pass) {
      this -> p_pass = pass;
   }
   
   string getP_x() {
      return this -> p_x;
   }

   void setP_x(string x) {
      this -> p_x = x;
   }

   int getData() {
      return this -> data;
   }

   void setData(int data) {
      this -> data = data;
   }
};


#endif
