gcloud config set project labparcsjava
gcloud config set compute/zone us-central1-c

gcloud compute instances create hosts-server daemon-1 daemon-2 app

gcloud compute ssh daemon-1

sudo apt-get update
sudo apt-get install -y default-jdk
sudo apt-get install -y wget
wget https://github.com/lionell/labs/raw/master/parcs/Daemon/Daemon.jar
java -jar Daemon.jar&

gcloud compute ssh hosts-server
sudo apt-get update
sudo apt-get install -y default-jdk
sudo apt-get install -y wget
wget https://github.com/lionell/labs/raw/master/parcs/HostsServer/TCPHostsServer.jar


touch hosts.list
echo 10.128.0.4 >> hosts.list
echo 10.128.0.5 >> hosts.list
java -jar TCPHostsServer.jar&

sudo apt-get update && sudo apt-get install -y default-jdk git make
git clone https://github.com/lionell/labs.git
mv labs/parcs/Bluck . && rm -rf labs
cd Bluck

echo 10.128.0.2 > out/server

make


gcloud compute instances delete daemon-1 daemon-2 hosts-server app