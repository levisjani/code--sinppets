/*
 * password.c
 * 
 * Copyright 2013 levis_cmdpunk <levisjani@rocketmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 */


#include <stdio.h>

int main(int argc, char **argv)
{
  int flag = 0;
	char passwd[10];
	
	memset(passwd, 0, sizeof(passwd));
	strcpy(passwd, argv[1]);
	
	if(0 == strcmp("LinuxGeek", passwd))
	{
		flag = 1;
		}
	if(flag)
	{
		printf("\n Password cracked\n");
		}	
	else
	{
		printf("\n Password not cracked\n");
		}	
		
	return 0;
}
