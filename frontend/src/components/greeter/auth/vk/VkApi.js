import React from "react";
import VkStyle from "./VkStyle";

class VkApi extends React.Component {
    componentDidMount() {
        this.asyncInit();
        this.loadSdkAsync();
    }

    asyncInit() {
        window.vkAsyncInit = () => {
            window.VK.init({
                apiId: 51462366
            });
            window.VK.Widgets.Auth('vk_auth', {
                width: 300, onAuth: this.props.callback,
            });
        }
    }

    loadSdkAsync() {
        const el = document.createElement('script');

        el.type = 'text/javascript';
        el.src = 'https://vk.com/js/api/openapi.js?169';
        el.async = true;
        el.id = 'vk-sdk';

        document.getElementsByTagName('head')[0].appendChild(el);
    }

    render() {
        return <div id="vk_auth" style={VkStyle}/>;
    }
}

export default VkApi;
