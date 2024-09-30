# capacitor-app-installer

CapacitorAppInstaller Capacitor Plugin

## Install

```bash
npm install capacitor-app-installer
npx cap sync
```

## API

<docgen-index>

* [`install(...)`](#install)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

The Capacitor App Installer Plugin.

### install(...)

```typescript
install(options: AppInstallOptions) => Promise<void>
```

Installs an application with the given options.

| Param         | Type                                                            | Description                             |
| ------------- | --------------------------------------------------------------- | --------------------------------------- |
| **`options`** | <code><a href="#appinstalloptions">AppInstallOptions</a></code> | - The options for the app installation. |

--------------------


### Interfaces


#### AppInstallOptions

Options for installing an application.

| Prop       | Type                | Description                           |
| ---------- | ------------------- | ------------------------------------- |
| **`file`** | <code>string</code> | The path to the file to be installed. |

</docgen-api>
