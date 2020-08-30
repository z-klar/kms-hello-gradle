package cz.zk.kmshellozk;

import org.kurento.client.MediaPipeline;
import org.kurento.client.WebRtcEndpoint;

public class UserSession {
    private MediaPipeline mediaPipeline;
    private WebRtcEndpoint webRtcEndpoint;

    public UserSession()
    {}

    public MediaPipeline getMediaPipeline()
    { return mediaPipeline; }

    public void setMediaPipeline(MediaPipeline mediaPipeline)
    { this.mediaPipeline = mediaPipeline; }

    public WebRtcEndpoint getWebRtcEndpoint()
    { return webRtcEndpoint; }

    public void setWebRtcEndpoint(WebRtcEndpoint webRtcEndpoint)
    { this.webRtcEndpoint = webRtcEndpoint; }
}

