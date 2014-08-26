//Demonstration program for hashing MAC's

#include <iostream.h>

#include "pk11pub.h"
#include "nss.h"

include namespace std;

static void
printfDigest(unsigned char *digest, unsigned int len)
{
	int i;
	cout << "length: " << len << endl;
	for (int i = 0; i < len; ++i)
	{
		printf("%02x ", digest[i]);
	}
 	cout << endl;
}

int main(int argc, char const *argv[])
{
	int status = 0;
	PK11SlotInfo *slot = 0;
	PK11SymKey *key = 0;
	PK11Context *context = 0;
	unsigned char data[80];
	unsigned char digest[20];
	unsigned int len;
	SECStatus s;

	/*Initialize NSS
	*if your app code has already initialized NSS, it can be skipped here
	*This sode uses the simplest of the init functions, which doesn't require
	*a NSS database to exit.*/

	NSS_NoDB_Init(".");

	//Get a slot to use for the crypto operations

	slot = PK11_GetInternalKeySlot();
	if (!slot)
	{
		cout << "GetInternalKeySlot failed" << endl;
		status = 1;
		goto done;
	}
	//Simple Hashing
	cout << "Part 1 -- Simple hashing" << endl;

    //Initialize data 
    memset(data, 0xbc, sizeof data);

    // Create a context for hashing (digesting) 
    context = PK11_CreateDigestContext(SEC_OID_MD5);
    if (!context) 
    { 
    	cout << "CreateDigestContext failed" << endl; 
    	goto done; 
    }

    s = PK11_DigestBegin(context);
    if (s != SECSuccess) 
    { 
    	cout << "DigestBegin failed" << endl; 
    	goto done; 
    }

    s = PK11_DigestOp(context, data, sizeof data);
    if (s != SECSuccess) 
    { 
    	cout << "DigestUpdate failed" << endl; 
    	goto done; 
    }

    s = PK11_DigestFinal(context, digest, &len, sizeof digest);
    if (s != SECSuccess) 
    { 
    	cout << "DigestFinal failed" << endl; 
    	goto done; 
    }

    // Print digest 
    printDigest(digest, len);

    PK11_DestroyContext(context, PR_TRUE);
    context = 0;

    //Hashing with included secret key

    cout << "Hashing with included secret key" << endl;

    //Initialize data
    memset(data, 0xbc, sizeof data);
    //Create Key
    key = PK11_KeyGen(slot, CKM_GENERIC_SECRET_KEY_GEN, 0, 128, 0);
    if (!key) 
    { 
    	cout << "Create key failed" << endl; 
    	goto done;
    }
    cout << (void *)key << endl;

    //Create parameters for crypro context
    // params != NULL
    SECItem noParams;
    noParams.type = siBuffer;
    noParams.data = 0;
    noParams.len = 0;

    //Create context using the same slot as the key
    context = PK11_CreateDigestContext(SEC_OID_MD5);
	context = PK11_CreateContextBySymKey(CKM_MD5, CKA_DIGEST, key, &noParams);
	if (s != SECSuccess)
    {
        cout << "DigestFinal failed" << endl;
        goto done;
    }
    
    //Print digest
    printDigest(digest, len);
    PK11_DestroyContext(context, PR_TRUE);
    context = 0

    //MAC address with secret key
    cout << "MAC with secret key" << endl;

    //Initialize data
    memset(data, 0xbc, sizeof data);

    context = PK11_CreateContextBySymKey(CKM_MD5_HMAC, CKA_SIGN, key, &noParams);
    if (!context) 
    { 
        cout << "CreateContextBySymKey failed" << endl; 
        goto done; 
    }

    s = PK11_DigestBegin(context);
    if (s != SECSuccess) 
    { 
        cout << "DigestBegin failed" << endl; 
        goto done; 
    }

    s = PK11_DigestOp(context, data, sizeof data);
    if (s != SECSuccess) 
    { 
        cout << "DigestOp failed" << endl; 
        goto done; 
    }

    s = PK11_DigestFinal(context, digest, &len, sizeof digest);
    if (s != SECSuccess) 
    { 
        cout << "DigestFinal failed" << endl; 
        goto done; 
    }

    //Print digest
    printDigest(digest, len);
    PK11_DestroyContext(context, PR_TRUE);
    context = 0;

    done:
        if (context)
        {
            PK11_DestroyContext(context, PR_TRUE);
        }

        if (key)
        {
            PK11_FreeSymKey(key);
        }

        if (slot)
        {
            PK11_FreeSlot(slot);
        }

return status;
return 0;
}
