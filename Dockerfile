FROM openjdk:8-jre

EXPOSE 8080
EXPOSE 5000/UDP

########################################################################################################
# Install GStreamer-1.0:
RUN apt-get update && apt-get install --no-install-recommends --yes \
        libgstreamer1.0-0 gstreamer1.0-dev gstreamer1.0-tools gstreamer1.0-doc \
        gstreamer1.0-plugins-base gstreamer1.0-plugins-good  \
		gstreamer1.0-plugins-bad gstreamer1.0-plugins-ugly \
		gstreamer1.0-libav \
		gstreamer1.0-doc gstreamer1.0-tools gstreamer1.0-x gstreamer1.0-alsa  gstreamer1.0-pulseaudio \
 && rm -rf /var/lib/apt/lists/*

#######################################################################################################
# Install nano: optional - standard openjdk source image does not have it
RUN apt-get update && apt-get install --no-install-recommends --yes \
        nano \
 && rm -rf /var/lib/apt/lists/*
#######################################################################################################


COPY build/libs/kms-hello-zk-0.0.1-SNAPSHOT.jar /var/app.jar
WORKDIR /var

ENTRYPOINT ["java","-jar","/var/app.jar" ]
