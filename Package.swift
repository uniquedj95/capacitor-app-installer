// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorAppInstaller",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorAppInstaller",
            targets: ["CapacitorAppInstallerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CapacitorAppInstallerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CapacitorAppInstallerPlugin"),
        .testTarget(
            name: "CapacitorAppInstallerPluginTests",
            dependencies: ["CapacitorAppInstallerPlugin"],
            path: "ios/Tests/CapacitorAppInstallerPluginTests")
    ]
)