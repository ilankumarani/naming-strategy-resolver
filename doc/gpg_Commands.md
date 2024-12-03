#### get all gpg keys ID
```bash
gpg --list-signatures --keyid-format 0xshort
```
[](keyName.jpg)

#### To list the keys in your public key ring:
```bash
gpg --list-keys
```

#### To list the keys in your secret key ring:
```bash
gpg --list-secret-keys
```

#### to delete a public key (from your public key ring):
```bash
gpg --delete-key 7D2BAF1CF37B13E2069D6956105BD0E739499BDB
```
---
This removes the public key from your public key ring.
<br/>
**NOTE! <br/>
    If there is a private key on your private key ring associated with this public key, you will get an error! You must delete your private key for this key pair from your private key ring first.**
---


#### to delete a private key (a key on your private key ring):
```bash
gpg --delete-secret-key 7D2BAF1CF37B13E2069D6956105BD0E739499BDB
```
