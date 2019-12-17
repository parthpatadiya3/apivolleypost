package com.example.apivolleypost;

class personlist
{
        String uname,email;

    public personlist() {

    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public personlist(String uname)
    {
        this.uname = uname;
    }

    public String getUname()
    {
        return uname;
    }

    public void setUname(String uname)
    {
        this.uname = uname;
    }
}
