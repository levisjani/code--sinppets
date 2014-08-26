#!/usr/bin/python

#import everything we need
import pxssh

#machine details
host = ''
user = ''
password = ''

#command to be sent
command = ''

#function to connect
def connect(hostname,username,password,release):
	try:
		s = pxssh.pxssh()
		s.login(hostname,username,password,release)
		return s
		print s
	except Exception, e:
		print "[-] Error connecting:" + str(e)

#function to send a command

def send_command(ssh_session, command):
		ssh_session.sendline(command)
		ssh_session.prompt()
		print ssh_session.before

session = connect(host,user,password)

def main():
	send_command(session,command)

if __name__ == "__main__":
	main()
