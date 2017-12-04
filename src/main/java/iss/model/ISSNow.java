package iss.model;

import java.util.Date;

/**
 *  Created by the http://pojo.sodhanalibrary.com/ tool.
 *
 *  Notice the Iss_position class to represent the nested iss_position object in the JSON response.
 */


public class ISSNow {
    
        private String timestamp;
        
        private String message;
        
        private Iss_position iss_position;
        
        public String getTimestamp ()
        {
            return timestamp;
        }
        
        public void setTimestamp (String timestamp)
        {
            this.timestamp = timestamp;
        }
        
        public String getMessage ()
        {
            return message;
        }
        
        public void setMessage (String message)
        {
            this.message = message;
        }
        
        public Iss_position getIss_position ()
        {
            return iss_position;
        }
        
        public void setIss_position (Iss_position iss_position)
        {
            this.iss_position = iss_position;
        }
        
        @Override
        public String toString()
        {
            return "ISSNow [timestamp = "+timestamp+", message = "+message+", iss_position = "+iss_position+"]";
        }

        
        // This class was automatically generated, plus this extra user-friendly output message.
        public String userString() {
            
            return String.format("At %s, the ISS is above latitude: %s, longitude: %s",
                    new Date(Long.parseLong(timestamp ) * 1000),   // Convert String to Long and mulitply by 1000, the Date constructor expects the timestamp to represent milliseconds, the API returns a timestamp in seconds
                    iss_position.getLatitude(),
                    iss_position.getLongitude());
        }
    }

