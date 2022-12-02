import VkApi from "./VkApi";
import {isMobile} from "react-device-detect";

const saveUserToSessionStorage = (data) => {
    sessionStorage.setItem("user",
        JSON.stringify({
            id: data.uid,
            name: data.first_name,
            surname: data.last_name,
            photo: data.photo,
            photoRec: data.photo_rec,
            hash: data.hash,
        })
    )

    authorizeInOAth();
}

const authorizeInOAth = () => {
    const display = isMobile ? "mobile" : "popup"
    const redirectUrl = window.location.href.slice(0, window.location.href.length - 1)

    window.location.assign(`https://oauth.vk.com/authorize?client_id=51462366&display=${display}&redirect_uri=${redirectUrl}&scope=262144&response_type=code`);
}

const VkAuth = () => {
    return <VkApi callback={saveUserToSessionStorage}/>
}

export default VkAuth;
