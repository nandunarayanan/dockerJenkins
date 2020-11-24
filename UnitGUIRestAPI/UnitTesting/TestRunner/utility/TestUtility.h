/*!
 * @file TestUtility.h
 * This header file contains the declaration of Utility functions required for server.
 *
 */

#include <vector>
#include <sstream>
#include <fstream>
#include <string>
#include <iostream>
/********************************/
// C++ Header File(s)
#include <iostream>
#include <map>
/*********************************/

using namespace std;
/*********************************/

	// Defining ConfigReader as singleton class
       // Easy to access across the multiple classes
       //
       // The responsibility of this class is to parse the
       // Config file and store it in the std::map
       // Defined getter function getValue() to get the
       // data from the std::map.
       //
       // To use this class, pass the config file path to
       // the function getInstance()
       //
       // This is one of the advance config reader, because this
       // class is handling the comment line as well. Comment line 
       // will start from hash(#). So all the string after
       // semicolon will be discarded.
       //
       // NOTE: NO NEED TO MAKE THIS CLASS THREAD-SAFE. IT IS EXTRA OVEHEAD.
       // BECAUSE MOSTLY WE ARE DOING ONLY READ OPERATION. WRITE OPERATION IS
       // HAPPENING ONLY ONE TIME, WHICH IS IN THE FUNCTION parse(). SO CALL
       // parse() FUNCTION AT THE TIME OF INITIALIZATION ONLY.
       //
       // IF YOUR CONFIGURATION FILE IS UPDATING AT THE RUN TIME AND YOU NEED
       // UPDATED DATA FROM THE CONFIGURATION FILE AT RUN TIME, THEN YOU NEED 
       // TO MAKE THIS CLASS THREAD-SAFE.

       class ConfigReader
       {
          private:
             
             // Define the map to store data from the config file
             std::map<std::string, std::string> m_ConfigSettingMap;

             // Static pointer instance to make this class singleton.
             static ConfigReader* m_pInstance;

          public:
             
             // Public static method getInstance(). This function is
             // responsible for object creation.
             static ConfigReader* getInstance();

             // Parse the config file.
             bool parseFile(std::string fileName = "/home/sachin/dfiles/dockerJenkins/UnitGUIRestAPI/UnitTesting/TestRunner/configuration/ConfigurationFile");

             // Overloaded getValue() function.
             // Value of the tag in cofiguration file could be
             // string or integer. So the caller need to take care this.
             // Caller need to call appropiate function based on the
             // data type of the value of the tag.

             bool getValue(std::string tag, int& value);
             bool getValue(std::string tag, std::string& value);

             // Function dumpFileValues is for only debug purpose
             void dumpFileValues();

          private:

             // Define constructor in the private section to make this
             // class as singleton.
             ConfigReader();

             // Define destructor in private section, so no one can delete 
             // the instance of this class.
             ~ConfigReader();

             // Define copy constructor in the private section, so that no one can 
             // voilate the singleton policy of this class
             ConfigReader(const ConfigReader& obj){}
             
             // Define assignment operator in the private section, so that no one can 
             // voilate the singleton policy of this class
             void operator=(const ConfigReader& obj){}

             // Helper function to trim the tag and value. These helper function is
             // calling to trim the un-necessary spaces.
             std::string trim(const std::string& str, const std::string& whitespace = " \t");
             std::string reduce(const std::string& str,
                   const std::string& fill = " ",
                   const std::string& whitespace = " \t");
       };

/*********************************/
/*!
 * @brief This class represents the Server Utility variables and functions
 */
class TestUtility
{
    /*!
     * @brief Private member variables.
     */
    string m_msgRecived;
    string m_msgPublish;
    bool m_stop_main;
  
  public:
     
    /*!
     * @brief Public member variables.
     */
    vector<string> words;
    vector<string> words1;
/**************************************************************************/
    /*!
     * @brief This function returns filepath of the file,fileName read from the
	configuration file
     * @return filepath of file fileName(filePath)
     */
    string getCsvFilePath(std::string fileName);
/**************************************************************************/    
    
  
    /*!
     * @brief This function returns a message recieved from AUT
     * @return recieved message(m_msgRecived)
     */
    string getMsg();
	
    /*!
     * @brief This function sets message recieved from AUT
     * @param recieved message
     */
    void setMsg(string msg);
	
    /*!
     * @brief This function sets boolean variable to stop sending test message
     * @param stop boolean variable
     */
    void setStopMain(bool s);
	
    /*!
     * @brief This function gets boolean variable to stop sending test message
     * @return stop boolean variable(m_stop_main)
     */
    bool getStopMain();
	
    /*!
     * @brief This function gets the message to be published to AUT
     * @return message to be published(m_msgPublish)
     */
    string getMsgPublish();    
	
    /*!
     * @brief This function sets the message to be published to AUT(m_msgPublish)
     * @param message to be published
     */
    void setMsgPublish(string msg);
	
    /*!
     * @brief This function evaluate the test case by sending the string 
	 *        passed to it and wait for the result from AUT
     * @param test case
     * @return result for the test case recieved from AUT
     */
    string evaluvateTestcase(string msg);
	
    /*!
     * @brief read the csv file line by line and save it in a vector and seperate the test cases and expected results
     * @param name of the file to be read
     */
    void readCSV(std::string filename);
    void readCSV1(std::string filename);
    /*!
     * @brief read the csv file line by line and save it in a vector
     * @param fileName name of the file to be read
     * @param vecOfStrs variable to save data from csv line by line
     */
    static bool getFileContent(std::string fileName, std::vector<std::string> & vecOfStrs);

    /*!
     * @brief Default constructor.
     */
    TestUtility (): m_msgRecived("")
	     , m_msgPublish("")
	     , m_stop_main(false)
   {
	
   }
};

/*!
 * @brief Subscriber Main thread function to send the messages from Test runner to test environment
 * @param s ServerUtility class pointer
 */
void SubscriberMain(TestUtility* s);

/*!
 * @brief Publisher Main thread function to recieve the messages from Test environment to test runner
 * @param s ServerUtility class pointer
 */
void PublisherMain(TestUtility* s);
