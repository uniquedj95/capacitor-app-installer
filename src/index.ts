import { registerPlugin } from '@capacitor/core';

import type { CapacitorAppInstallerPlugin } from './definitions';

const CapacitorAppInstaller = registerPlugin<CapacitorAppInstallerPlugin>('CapacitorAppInstaller', {
  web: () => import('./web').then((m) => new m.CapacitorAppInstallerWeb()),
});

export * from './definitions';
export { CapacitorAppInstaller };
