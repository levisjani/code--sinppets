/*
 * buffer.c
 * 
 * Copyright 2013 levis_jani <levisjani@rocketmail.com>
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
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */


#include <stdio.h>
#include <string.h>
#include <ncurses.h>


int main(int argc, char **argv)
{
  char buff[15];
	int pass = 0;
	
	printf("\n Etnter the password: \n");
	gets(buff);
	
	if(strcmp(buff, "thegeekstuff"))
	{
		printf("\n Worng Password \n");
		}
	else
	{
		printf("\n Correct Password \n");
		pass = 1;
		}	
	if(pass)
	{
		printf("\n Root privileges granted\n");
		}	
		
	getch();
	return 0;
}
