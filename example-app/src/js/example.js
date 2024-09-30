import { CapacitorAppInstaller } from 'capacitor-app-installer';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    CapacitorAppInstaller.echo({ value: inputValue })
}
