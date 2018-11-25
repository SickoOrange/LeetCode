class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> set=new HashSet<>();
        for(String email:emails){
            String hostName=email.substring(0,email.indexOf("@"));
            String domainName=email.substring(email.indexOf("@"));
            String host=hostName.substring(0,hostName.indexOf("+")).replaceAll(".","");
            set.add(host+domainName);
        }
        
        return set.size();
        
    }
}


//trick solution